import java.util.HashMap;
import java.util.Map;

/**
 * CacheManager - Patrón Singleton
 * Gestiona un cache simple en memoria
 */
public class CacheManager {

    // Instancia única (Singleton)
    private static CacheManager instance;

    // Almacén de datos
    private Map<String, Object> cache;

    // Constructor privado - nadie puede crear instancias desde fuera
    private CacheManager() {
        this.cache = new HashMap<>();
        System.out.println("✓ CacheManager creado");
    }

    // Método para obtener la única instancia
    public static CacheManager getInstance() {
        if (instance == null) {
            instance = new CacheManager();
        }
        return instance;
    }

    // Agregar dato al cache
    public void save(String key, Object value) {
        cache.put(key, value);
        System.out.println("✓ Guardado: " + key);
    }

    // Obtener dato del cache
    public Object get(String key) {
        Object value = cache.get(key);
        if (value != null) {
            System.out.println("✓ Encontrado: " + key);
        } else {
            System.out.println("✗ No encontrado: " + key);
        }
        return value;
    }

    // Eliminar dato del cache
    public void remove(String key) {
        cache.remove(key);
        System.out.println("✓ Eliminado: " + key);
    }

    // Ver cuántos elementos hay
    public int size() {
        return cache.size();
    }

    // Limpiar todo el cache
    public void clear() {
        cache.clear();
        System.out.println("✓ Cache limpiado");
    }
}