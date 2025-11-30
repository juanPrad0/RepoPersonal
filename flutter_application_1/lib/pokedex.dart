import 'dart:math';
import 'ataques.dart';

/// =========================
///        MODELO
/// =========================

enum Elementos { Normal, Fuego, Agua, Electrico, Hierba, Hielo, Lucha, Veneno, Tierra, Volador, Psiquico, Bicho, Roca, Fantasma, Dragon, Siniestro, Acero}
enum Estados { Paralizado, Dormido, Quemado, Congelado, Envenenado }

class Pokemon {
  final String nombre;
  final int nivel;
  final Set<Elementos> tipo; // Tipo de elemento
  final List<Ataque> ataques; // Lista de ataques
  final Map<Estados, int> estados = {}; // Estados y su duración
  

  final String spriteFront; // Imagen de frente (para el oponente)
  final String spriteBack;  // Imagen de espalda (para mi pokemon)
  
  double vida;
  final double velocidad;
  static final Random _random = Random();

  Pokemon({
    required this.nombre,
    required this.nivel,
    required this.tipo,
    required this.ataques,
    // --- REQUERIDOS EN EL CONSTRUCTOR ---
    required this.spriteFront, 
    required this.spriteBack,
  })  : vida = (_random.nextDouble() * 5 + 5) * nivel,
        velocidad = (_random.nextDouble() * 3 + 1) * nivel;
}

// Nuestros Pokemones (de cada tipo)
// He añadido las URLs de PokeAPI correspondientes a cada Pokémon
final List<Pokemon> pokedex = [
  Pokemon(
    nombre: "Snorlax", 
    nivel: 1, 
    tipo: {Elementos.Normal}, 
    ataques: [tacleada],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/143.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/143.png"
  ),
  Pokemon(
    nombre: "Charmander", 
    nivel: 1, 
    tipo: {Elementos.Fuego}, 
    ataques: [lanzallamas],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/4.png"
  ),
  Pokemon(
    nombre: "Squirtle", 
    nivel: 1, 
    tipo: {Elementos.Agua}, 
    ataques: [hidroBomba],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/7.png"
  ),
  Pokemon(
    nombre: "Pikachu", 
    nivel: 1, 
    tipo: {Elementos.Electrico}, 
    ataques: [rayo],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/25.png"
  ),
  Pokemon(
    nombre: "Chikorita", 
    nivel: 1, 
    tipo: {Elementos.Hierba}, 
    ataques: [hojaAfilada],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/152.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/152.png"
  ),
  Pokemon(
    nombre: "Glaceon", 
    nivel: 1, 
    tipo: {Elementos.Hielo}, 
    ataques: [rayoHielo],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/471.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/471.png"
  ),
  Pokemon(
    nombre: "Machamp", 
    nivel: 1, 
    tipo: {Elementos.Lucha}, 
    ataques: [golpeKarate],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/68.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/68.png"
  ),
  Pokemon(
    nombre: "Arbok", 
    nivel: 1, 
    tipo: {Elementos.Veneno}, 
    ataques: [bombaAcida],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/24.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/24.png"
  ),
  Pokemon(
    nombre: "Cubone", 
    nivel: 1, 
    tipo: {Elementos.Tierra}, 
    ataques: [terremoto],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/104.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/104.png"
  ),
  Pokemon(
    nombre: "Tornadus", 
    nivel: 1, 
    tipo: {Elementos.Volador}, 
    ataques: [vendaval],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/641.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/641.png"
  ),
  Pokemon(
    nombre: "Mewtwo", 
    nivel: 1, 
    tipo: {Elementos.Psiquico}, 
    ataques: [psiquico],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/150.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/150.png"
  ),
  Pokemon(
    nombre: "Pinsir", 
    nivel: 1, 
    tipo: {Elementos.Bicho}, 
    ataques: [tijeraX],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/127.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/127.png"
  ),
  Pokemon(
    nombre: "Sudowoodo", 
    nivel: 1, 
    tipo: {Elementos.Roca}, 
    ataques: [avalancha],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/185.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/185.png"
  ),
  Pokemon(
    nombre: "Misdreavus", 
    nivel: 1, 
    tipo: {Elementos.Fantasma}, 
    ataques: [bolaSombra],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/200.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/200.png"
  ),
  Pokemon(
    nombre: "Dratini", 
    nivel: 1, 
    tipo: {Elementos.Dragon}, 
    ataques: [garraDragon],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/147.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/147.png"
  ),
  Pokemon(
    nombre: "Umbreon", 
    nivel: 1, 
    tipo: {Elementos.Siniestro}, 
    ataques: [pulsoUmbrio],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/197.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/197.png"
  ),
  Pokemon(
    nombre: "Magnemite", 
    nivel: 1, 
    tipo: {Elementos.Acero}, 
    ataques: [focoResplandor],
    spriteFront: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/81.png",
    spriteBack: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/81.png"
  ),
];