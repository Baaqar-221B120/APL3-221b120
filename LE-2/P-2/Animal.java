class Animal {
    String name;
    String voice;

    Animal(String name, String voice) {
        this.name = name;
        this.voice = voice;
    }

    void makeSound() {
        System.out.println(name + " says: " + voice);
    }
}