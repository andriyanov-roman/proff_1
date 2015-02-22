package lessonForSinglePattern;


public class MySingleton {                               //  разрешает создавать только один екземпляр этого класса
    private static MySingleton instance = null;          // поздняя инициализация

    private MySingleton() {                              // конструктор  приватный !!
    }

    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }
}
