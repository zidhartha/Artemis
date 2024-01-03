
public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Chip", 15);
        Animal animal2 = new Animal("Chip", 30);
        System.out.println(animal1.toString());
        System.out.println(animal2.toString());
        Animal[] animals = new Animal[]{animal2, animal1};
        Vivarium vivarium = new Vivarium(animals, 200, 1985);
        System.out.println(vivarium.toString());
        System.out.println(vivarium.getCosts());
        Animal animal3 = new Animal("Wolf", 1);
        Animal animal4 = new Animal("Wolf", 2);
        Animal[] animals2 = new Animal[]{animal3, animal4};
        Vivarium vivarium2 = new Vivarium(animals2, 200, 1985);
        System.out.println(vivarium2.toString());
        System.out.println(vivarium2.getCosts());
        Zoo zoo = new Zoo(new Vivarium[]{vivarium, vivarium2});
        System.out.println(zoo.getCosts());
        System.out.println(zoo.toString());
        Animal kitties = new Animal( "bacuci",12);
        Animal pingu = new Animal("pinguina",13);
        Animal felix = new Animal("chillin",16);
        System.out.println(kitties.toString());
        Animal[] inhabitants = {pingu,felix};
        System.out.println(vivarium.toString());




    }
}
