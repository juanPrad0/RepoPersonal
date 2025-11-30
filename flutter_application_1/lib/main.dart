import 'package:flutter/material.dart';
import 'dart:math';
import 'pokedex.dart';
import 'ataques.dart';

void main() {
  runApp(const PokemonApp());
}

class PokemonApp extends StatelessWidget {
  const PokemonApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Batalla Pokémon',
      theme: ThemeData(useMaterial3: true, colorSchemeSeed: Colors.red),
      home: const BattleScreen(),
    );
  }
}

class BattleScreen extends StatefulWidget {
  const BattleScreen({super.key});

  @override
  State<BattleScreen> createState() => _BattleScreenState();
}

class _BattleScreenState extends State<BattleScreen> {
  // Variables para controlar la batalla
  late Pokemon miPokemon;
  late Pokemon oponentePokemon;
  
  late double miVidaMax;
  late double oponenteVidaMax;

  List<String> combatLog = []; // Ahora es una lista vacía
  
  // NUEVA VARIABLE: Para bloquear los botones mientras se espera
  bool turnoEnProgreso = false; 

  @override
  void initState() {
    super.initState();
    iniciarBatalla();
  }

  void agregarLog(String mensaje) {
    setState(() {
      // Insertamos en la posición 0 para que lo nuevo salga arriba
      combatLog.insert(0, mensaje); 
    });
  }
  void iniciarBatalla() {
    setState(() {
      // Puedes cambiar los índices para probar otros Pokémon
      miPokemon = pokedex[3]; // Pikachu
      oponentePokemon = pokedex[1]; // Charmander

      miVidaMax = miPokemon.vida;
      oponenteVidaMax = oponentePokemon.vida;
      
      agregarLog("¡Un ${oponentePokemon.nombre} salvaje apareció!");
      turnoEnProgreso = false;
    });
  }

  // --- AQUÍ ESTÁ LA MAGIA DEL DELAY ---
  // Agregamos 'async' para poder usar esperas
  void realizarTurno(Ataque ataqueSeleccionado) async {
    
    // 1. Bloqueamos los botones para que no puedas spamear ataques
    setState(() {
      turnoEnProgreso = true;
    });

    // --- FASE 1: TU ATAQUE ---
    setState(() {
      double multiplicador = TablaDanio.obtenerDanioTotal(ataqueSeleccionado.tipo, oponentePokemon);
      double danioFinal = ataqueSeleccionado.danio * multiplicador;

      oponentePokemon.vida -= danioFinal;
      if (oponentePokemon.vida < 0) oponentePokemon.vida = 0;

      String eficacia = "";
      if (multiplicador > 1.0) eficacia = "¡Es súper efectivo!";
      if (multiplicador < 1.0 && multiplicador > 0) eficacia = "No es muy eficaz...";
      if (multiplicador == 0) eficacia = "¡No afecta!";

      agregarLog("${miPokemon.nombre} usó ${ataqueSeleccionado.nombre}.\n$eficacia");
    });

    // 2. Comprobar si ganaste ANTES de esperar
    if (oponentePokemon.vida <= 0) {
      setState(() {
        agregarLog("¡${oponentePokemon.nombre} se debilitó! ¡Ganaste!");
        // No desbloqueamos 'turnoEnProgreso' para que termine el juego visualmente
      });
      return; 
    }

    // --- PAUSA DE DRAMATISMO (2 SEGUNDOS) ---
    await Future.delayed(const Duration(seconds: 2));

    // Si el widget ya no existe (el usuario se salió), paramos
    if (!mounted) return;

    // --- FASE 2: TURNO RIVAL ---
    setState(() {
      if (oponentePokemon.ataques.isNotEmpty) {
         // El rival elige un ataque al azar
         var random = Random();
         Ataque ataqueRival = oponentePokemon.ataques[random.nextInt(oponentePokemon.ataques.length)];
         
         double multRival = TablaDanio.obtenerDanioTotal(ataqueRival.tipo, miPokemon);
         double danioRival = ataqueRival.danio * multRival;
         
         miPokemon.vida -= danioRival;
         if (miPokemon.vida < 0) miPokemon.vida = 0;
         
         String eficaciaRival = "";
         if (multRival > 1.0) eficaciaRival = "¡Te dolió mucho!";

         agregarLog("El rival usó ${ataqueRival.nombre}.\n$eficaciaRival Daño: ${danioRival.toStringAsFixed(1)}");
      }

      // 3. Comprobar si perdiste
      if (miPokemon.vida <= 0) {
        "¡${miPokemon.nombre} se debilitó! Perdiste...";
      } else {
        // Si nadie perdió, desbloqueamos los botones para el siguiente turno
        turnoEnProgreso = false; 
      }
    });
  }

  Color getColorElemento(Elementos elemento) {
    switch (elemento) {
      case Elementos.Fuego: return Colors.orange;
      case Elementos.Agua: return Colors.blue;
      case Elementos.Hierba: return Colors.green;
      case Elementos.Electrico: return Colors.yellow[700]!;
      case Elementos.Psiquico: return Colors.purpleAccent;
      case Elementos.Hielo: return Colors.cyanAccent;
      case Elementos.Lucha: return Colors.brown;
      case Elementos.Veneno: return Colors.purple;
      case Elementos.Tierra: return Colors.brown[300]!;
      case Elementos.Volador: return Colors.lightBlueAccent;
      case Elementos.Bicho: return Colors.lightGreen;
      case Elementos.Roca: return Colors.grey;
      case Elementos.Fantasma: return Colors.indigo;
      case Elementos.Dragon: return Colors.deepPurple;
      case Elementos.Acero: return Colors.blueGrey;
      case Elementos.Siniestro: return Colors.black87;
      default: return Colors.grey;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(title: const Text("Batalla Pokémon"), centerTitle: true, backgroundColor: Colors.redAccent, foregroundColor: Colors.white),
      body: Center(
        child: Container(
          constraints: const BoxConstraints(maxWidth: 500),
          decoration: BoxDecoration(
            color: Colors.white, // Color base por si falla la imagen
            // Borde y sombra (opcional, para estilo GameBoy)
            border: Border.all(color: Colors.black, width: 4),
            boxShadow: [BoxShadow(color: Colors.black45, blurRadius: 10, offset: Offset(5, 5))],
            
            // --- AQUÍ VA LA IMAGEN DE FONDO ---
            image: const DecorationImage(
              // Usamos una imagen de "campo de batalla" de internet
              image: AssetImage("assets/fondo.png"), 
              fit: BoxFit.cover, // Esto hace que la imagen cubra todo el fondo sin deformarse
              alignment: Alignment.bottomCenter, // Alineamos al suelo
            ),
          ),
          child: Column(
            children: [
              // --- ÁREA VISUAL ---
              Expanded(
                flex: 3,
                child: Stack(
                  children: [
                    Positioned(
                      top: 20, right: 20,
                      child: PokemonDisplay(pokemon: oponentePokemon, maxVida: oponenteVidaMax, imgUrl: oponentePokemon.spriteFront),
                    ),
                    Positioned(
                      bottom: 20, left: 20,
                      child: PokemonDisplay(pokemon: miPokemon, maxVida: miVidaMax, imgUrl: miPokemon.spriteBack),
                    ),
                  ],
                ),
              ),

              // --- LOG DE BATALLA (CON SCROLL) ---
              Container(
                width: double.infinity,
                height: 120, // Lo hice un poco más alto para ver mejor
                decoration: BoxDecoration(
                  color: Colors.black87,
                  border: Border.all(color: Colors.grey),
                ),
                child: ListView.builder(
                  padding: const EdgeInsets.all(10),
                  // Esto asegura que la lista se construya eficientemente
                  itemCount: combatLog.length, 
                  itemBuilder: (context, index) {
                    return Padding(
                      padding: const EdgeInsets.symmetric(vertical: 2.0),
                      child: Text(
                        combatLog[index],
                        textAlign: TextAlign.left, // Alineado a la izquierda como lista
                        style: TextStyle(
                          color: index == 0 ? Colors.yellow : Colors.white70, // El último mensaje resalta en amarillo
                          fontSize: 14,
                          fontFamily: 'Courier',
                        ),
                      ),
                    );
                  },
                ),
              ),

              // --- MENÚ DE ATAQUES ---
              Expanded(
                flex: 2,
                child: Container(
                  color: Colors.grey[200],
                  padding: const EdgeInsets.all(10),
                  child: Column(
                    children: [
                      Text(turnoEnProgreso ? "Esperando al rival..." : "¿Qué hará ${miPokemon.nombre}?", 
                          style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 18)),
                      const SizedBox(height: 10),
                      Expanded(
                        child: GridView.builder(
                          gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                            crossAxisCount: 2,
                            childAspectRatio: 3.0,
                            crossAxisSpacing: 10,
                            mainAxisSpacing: 10,
                          ),
                          itemCount: miPokemon.ataques.length,
                          itemBuilder: (context, index) {
                            final ataque = miPokemon.ataques[index];
                            
                            // Lógica para habilitar/deshabilitar botones
                            final bool botonesHabilitados = !turnoEnProgreso && miPokemon.vida > 0 && oponentePokemon.vida > 0;

                            return ElevatedButton(
                              style: ElevatedButton.styleFrom(
                                backgroundColor: botonesHabilitados ? getColorElemento(ataque.tipo) : Colors.grey, // Se ponen grises si están bloqueados
                                foregroundColor: Colors.white,
                              ),
                              // Si turnoEnProgreso es TRUE, onPressed es null (botón desactivado)
                              onPressed: botonesHabilitados ? () => realizarTurno(ataque) : null,
                              child: Text(ataque.nombre),
                            );
                          },
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

// Widget auxiliar para mostrar la info del Pokémon
class PokemonDisplay extends StatelessWidget {
  final Pokemon pokemon;
  final double maxVida;
  final String imgUrl;

  const PokemonDisplay({
    super.key, 
    required this.pokemon, 
    required this.maxVida, 
    required this.imgUrl
  });

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Text(pokemon.nombre, style: const TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
        SizedBox(
          width: 120,
          child: LinearProgressIndicator(
            value: pokemon.vida / maxVida,
            color: (pokemon.vida / maxVida) > 0.5 ? Colors.green : Colors.red,
            backgroundColor: Colors.grey[300],
            minHeight: 8,
          ),
        ),
        Text("${pokemon.vida.toStringAsFixed(0)} / ${maxVida.toStringAsFixed(0)} HP"),
        Image.network(imgUrl, scale: 0.6, errorBuilder: (c,e,s) => const Icon(Icons.error)),
      ],
    );
  }
}