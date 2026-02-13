public class Main {

    public static void main(String[] args) {

        System.out.println("=== DEMO: Patrón Singleton - CacheManager ===\n");

        // 1. Obtener la instancia del cache
        System.out.println("1. Obteniendo instancia del cache:");
        CacheManager cache = CacheManager.getInstance();

        System.out.println("\n2. Verificando que es Singleton:");
        CacheManager cache2 = CacheManager.getInstance();
        System.out.println("¿Son la misma instancia? " + (cache == cache2));

        // 2. Guardar datos en el cache
        System.out.println("\n3. Guardando datos:");
        User user1 = new User("Juan", "juan@email.com");
        User user2 = new User("María", "maria@email.com");

        cache.save("user:1", user1);
        cache.save("user:2", user2);
        cache.save("config:app_name", "Mi Aplicación");
        cache.save("config:version", "1.0.0");

        // 3. Obtener datos del cache
        System.out.println("\n4. Obteniendo datos:");
        User retrievedUser = (User) cache.get("user:1");
        System.out.println("Usuario recuperado: " + retrievedUser);

        String appName = (String) cache.get("config:app_name");
        System.out.println("Nombre app: " + appName);

        // Intentar obtener algo que no existe
        cache.get("user:999");

        // 4. Ver tamaño del cache
        System.out.println("\n5. Información del cache:");
        System.out.println("Elementos en cache: " + cache.size());

        // 5. Eliminar un elemento
        System.out.println("\n6. Eliminando un elemento:");
        cache.remove("user:2");
        System.out.println("Elementos en cache: " + cache.size());

        // 6. Usar el cache desde otro lugar (mismo cache!)
        System.out.println("\n7. Accediendo desde otra parte del código:");
        CacheManager cacheFromAnotherPlace = CacheManager.getInstance();
        User userFromAnotherPlace = (User) cacheFromAnotherPlace.get("user:1");
        System.out.println("Usuario desde otra parte: " + userFromAnotherPlace);

        // 7. Limpiar el cache
        System.out.println("\n8. Limpiando cache:");
        cache.clear();
        System.out.println("Elementos en cache: " + cache.size());

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}