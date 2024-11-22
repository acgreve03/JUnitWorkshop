class Item {
    double price;
    int stock;

    Item(double price, int numPieces) {
        this.price = price;
        this.stock = numPieces;
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
    }
