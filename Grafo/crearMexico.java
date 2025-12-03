public class crearMexico {
    public static grafoPais crear() {
        grafoPais grafoMexico = new grafoPais();
        
        grafoMexico.agregarCiudad(new nodoEstado("Aguascalientes", "Aguascalientes", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Baja California", "Mexicali",false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Baja California Sur", "La Paz", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Campeche", "San Francisco de Campeche", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Chiapas", "Tuxtla Gutiérrez", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Chihuahua", "Chihuahua",false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Ciudad de México", "Ciudad de México", true, "Principal"));
        grafoMexico.agregarCiudad(new nodoEstado("Coahuila", "Saltillo", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Colima", "Colima", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Durango", "Durango", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Guanajuato", "Guanajuato", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Guerrero", "Chilpancingo", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Hidalgo", "Pachuca", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Jalisco", "Guadalajara", true, "Secundario"));
        grafoMexico.agregarCiudad(new nodoEstado("Estado de México", "Toluca", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Michoacán", "Morelia", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Morelos", "Cuernavaca", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Nayarit", "Tepic", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Nuevo León", "Monterrey", true, "Secundario"));
        grafoMexico.agregarCiudad(new nodoEstado("Oaxaca", "Oaxaca de Juárez", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Puebla", "Puebla de Zaragoza", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Querétaro", "Santiago de Querétaro", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Quintana Roo", "Chetumal", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("San Luis Potosí", "San Luis Potosí", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Sinaloa", "Culiacán", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Sonora", "Hermosillo", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Tabasco", "Villahermosa", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Tamaulipas", "Ciudad Victoria", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Tlaxcala", "Tlaxcala", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Veracruz", "Xalapa", false, "Cliente"));
        grafoMexico.agregarCiudad(new nodoEstado("Yucatán", "Mérida",true, "Secundario"));
        grafoMexico.agregarCiudad(new nodoEstado("Zacatecas", "Zacatecas", false, "Cliente"));

        
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Baja California"), grafoMexico.buscarCiudad("Baja California Sur"), 1050);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Baja California"), grafoMexico.buscarCiudad("Sonora"), 630);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Sonora"), grafoMexico.buscarCiudad("Chihuahua"), 480);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Sonora"), grafoMexico.buscarCiudad("Sinaloa"), 790);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Chihuahua"), grafoMexico.buscarCiudad("Coahuila"), 450);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Chihuahua"), grafoMexico.buscarCiudad("Durango"), 530);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Chihuahua"), grafoMexico.buscarCiudad("Sinaloa"), 630);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Coahuila"), grafoMexico.buscarCiudad("Nuevo León"), 270);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Coahuila"), grafoMexico.buscarCiudad("Durango"), 400);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Coahuila"), grafoMexico.buscarCiudad("Zacatecas"), 333);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Nuevo León"), grafoMexico.buscarCiudad("Tamaulipas"), 240);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Nuevo León"), grafoMexico.buscarCiudad("San Luis Potosí"), 400);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Nuevo León"), grafoMexico.buscarCiudad("Zacatecas"), 400);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Tamaulipas"), grafoMexico.buscarCiudad("Veracruz"), 660);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Tamaulipas"), grafoMexico.buscarCiudad("San Luis Potosí"), 415);

        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Sinaloa"), grafoMexico.buscarCiudad("Durango"), 200);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Sinaloa"), grafoMexico.buscarCiudad("Nayarit"), 250);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Durango"), grafoMexico.buscarCiudad("Zacatecas"), 255);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Durango"), grafoMexico.buscarCiudad("Nayarit"), 280);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Nayarit"), grafoMexico.buscarCiudad("Zacatecas"), 280);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Nayarit"), grafoMexico.buscarCiudad("Jalisco"), 185);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Jalisco"), grafoMexico.buscarCiudad("Zacatecas"), 245);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Jalisco"), grafoMexico.buscarCiudad("Aguascalientes"), 175);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Jalisco"), grafoMexico.buscarCiudad("San Luis Potosí"), 300);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Jalisco"), grafoMexico.buscarCiudad("Guanajuato"), 265);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Jalisco"), grafoMexico.buscarCiudad("Michoacán"), 200);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Jalisco"), grafoMexico.buscarCiudad("Colima"), 165);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Colima"), grafoMexico.buscarCiudad("Michoacán"), 175);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Michoacán"), grafoMexico.buscarCiudad("Guanajuato"), 180);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Michoacán"), grafoMexico.buscarCiudad("Querétaro"), 220);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Michoacán"), grafoMexico.buscarCiudad("Estado de México"), 250);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Michoacán"), grafoMexico.buscarCiudad("Guerrero"), 350);

        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Aguascalientes"), grafoMexico.buscarCiudad("Zacatecas"), 105);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Zacatecas"), grafoMexico.buscarCiudad("San Luis Potosí"), 180);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Zacatecas"), grafoMexico.buscarCiudad("Guanajuato"), 240);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("San Luis Potosí"), grafoMexico.buscarCiudad("Veracruz"), 600);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("San Luis Potosí"), grafoMexico.buscarCiudad("Hidalgo"), 290);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("San Luis Potosí"), grafoMexico.buscarCiudad("Querétaro"), 185);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("San Luis Potosí"), grafoMexico.buscarCiudad("Guanajuato"), 180);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Guanajuato"), grafoMexico.buscarCiudad("Querétaro"), 50);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Querétaro"), grafoMexico.buscarCiudad("Hidalgo"), 130);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Querétaro"), grafoMexico.buscarCiudad("Estado de México"), 165);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Hidalgo"), grafoMexico.buscarCiudad("Veracruz"), 350);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Hidalgo"), grafoMexico.buscarCiudad("Puebla"), 160);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Hidalgo"), grafoMexico.buscarCiudad("Tlaxcala"), 140);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Hidalgo"), grafoMexico.buscarCiudad("Estado de México"), 90);

        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Estado de México"), grafoMexico.buscarCiudad("Tlaxcala"), 150);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Estado de México"), grafoMexico.buscarCiudad("Puebla"), 155);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Estado de México"), grafoMexico.buscarCiudad("Ciudad de México"), 55);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Estado de México"), grafoMexico.buscarCiudad("Morelos"), 90);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Estado de México"), grafoMexico.buscarCiudad("Guerrero"), 200);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Ciudad de México"), grafoMexico.buscarCiudad("Morelos"), 65);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Morelos"), grafoMexico.buscarCiudad("Puebla"), 85);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Morelos"), grafoMexico.buscarCiudad("Guerrero"), 160);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Tlaxcala"), grafoMexico.buscarCiudad("Puebla"), 30);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Puebla"), grafoMexico.buscarCiudad("Veracruz"), 220);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Puebla"), grafoMexico.buscarCiudad("Oaxaca"), 270);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Puebla"), grafoMexico.buscarCiudad("Guerrero"), 225);

        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Guerrero"), grafoMexico.buscarCiudad("Oaxaca"), 295);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Oaxaca"), grafoMexico.buscarCiudad("Veracruz"), 245);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Oaxaca"), grafoMexico.buscarCiudad("Chiapas"), 385);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Veracruz"), grafoMexico.buscarCiudad("Tabasco"), 365);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Veracruz"), grafoMexico.buscarCiudad("Chiapas"), 430);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Tabasco"), grafoMexico.buscarCiudad("Campeche"), 325);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Tabasco"), grafoMexico.buscarCiudad("Chiapas"), 225);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Campeche"), grafoMexico.buscarCiudad("Yucatán"), 160);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Campeche"), grafoMexico.buscarCiudad("Quintana Roo"), 250);
        grafoMexico.agregarArista(grafoMexico.buscarCiudad("Yucatán"), grafoMexico.buscarCiudad("Quintana Roo"), 280);

        return grafoMexico;
    }
}