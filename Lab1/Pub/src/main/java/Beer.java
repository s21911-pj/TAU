public class Beer {
    private int id;

    private String name;

    private int size;




    public Beer(int id, String name, int size) {

        this.id = id;

        this.name = name;

        this.size = size;

    }




    public int getId() {

        return id;

    }




    public String getName() {

        return name;

    }




    public int getSize() {

        return size;

    }




    @Override

    public String toString() {

        return "Beer{" +

                "id=" + id +

                ", name='" + name + '\'' +

                ", size=" + size +

                '}';

    }

}


