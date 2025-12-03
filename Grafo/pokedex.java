public class pokedex {
    baseDatos baseDatosPokemon = new baseDatos();

    public baseDatos makeBaseDatosPokemon() {
        agregarPokemons();
        return baseDatosPokemon;
    }

    private void agregarPokemons(){
        baseDatosPokemon.addDato("Snorlax", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/143.png");
        baseDatosPokemon.addDato("Charmander", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png");
        baseDatosPokemon.addDato("Squirtle", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png");
        baseDatosPokemon.addDato("Pikachu", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png");
        baseDatosPokemon.addDato("Chikorita", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/152.png");
        baseDatosPokemon.addDato("Glaceon", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/471.png");
        baseDatosPokemon.addDato("Machamp", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/68.png");
        baseDatosPokemon.addDato("Arbok", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/24.png");
        baseDatosPokemon.addDato("Cubone", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/104.png");
        baseDatosPokemon.addDato("Tornadus", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/641.png");
        baseDatosPokemon.addDato("Mewtwo", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/150.png");
        baseDatosPokemon.addDato("Pinsir", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/127.png");
        baseDatosPokemon.addDato("Sudowoodo", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/185.png");
        baseDatosPokemon.addDato("Misdreavus", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/200.png");
        baseDatosPokemon.addDato("Dratini", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/147.png");
        baseDatosPokemon.addDato("Umbreon", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/197.png");
        baseDatosPokemon.addDato("Magnemite", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/81.png");
    }
}