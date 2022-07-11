package com.example.Blacksmith;

public class Blacksmith {
    
    private String title;
    private Stuff stuff;
    private boolean isCreate = false;

    public Blacksmith() {}

    public Blacksmith(String title){
        this.title = title;
    }

    public boolean orderStuff(String title, String material) {
        if (!isCreate) {
            this.stuff = new Stuff(title, material);
            this.isCreate = true;
            return true;
        }
        return false;
    }

    public String getStuffTitle() throws NullPointerException {
        if (stuff == null) throw new NullPointerException();
        return stuff.getTitle();
    }

    public String getStuffMaterial() throws NullPointerException {
        if (stuff == null) throw new NullPointerException();
        return stuff.getMaterial();
    }

    public void checkOrder() {
        if (isCreate && stuff != null) {
            System.out.println("Предмет: " + stuff.getTitle());
            System.out.println("Материал: " + stuff.getMaterial());
        }
    }

    public boolean pickUpOrder() {
        if (isCreate){
            this.stuff = null;
            this.isCreate = false;
            return true;
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public Stuff getStuff() throws NullPointerException {
        if (stuff == null) throw new NullPointerException();
        return stuff;
    }

    public boolean getCreate() {
        return isCreate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public void setCreate(boolean isCreate) {
        this.isCreate = isCreate;
    }
 
    private String privateTest(){
        return "Private method";
    }
}
