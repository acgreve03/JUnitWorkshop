class Item {
    double price;
    int stock;
    String name;

    Item(String name, double price, int numPieces) {
        this.price = price;
        this.stock = numPieces;
        this.name = name;
    }

    void setName(String newName){
        this.name = newName;
    }

    String getName(){
        return this.name;
    }

    double getPrice(){
        return this.price;
    }
    void restock(int amount) {
        this.stock = this.stock + amount;
    }

    void purchase(int amount) {
        if (amount > 0) {
            this.stock = this.stock - amount;
        }

        else{
            System.out.println("cannot purchase a negative amount.");
        }
    }

    int getStock() {return this.stock;}

    void setStock(int newStock){
        this.stock = newStock;
    }
    }
