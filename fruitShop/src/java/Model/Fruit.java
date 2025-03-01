package Model;

import java.io.Serializable;


public class Fruit implements Serializable {
   private int productId;
    private String productName;
    private String description;
    private String category;
    private double price;
    private int stockQuantity;
    private String image;
    private String until;

    public Fruit() {
    }

    public Fruit(int productId, String productName, String description, String category, double price, int stockQuantity, String image, String until) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.image = image;
        this.until = until;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
    }

    @Override
    public String toString() {
        return "Fruit{" + "productId=" + productId + ", productName=" + productName + ", description=" + description + ", category=" + category + ", price=" + price + ", stockQuantity=" + stockQuantity + ", image=" + image + ", until=" + until + '}';
    }

  
     
    
    public Fruit(Fruit s){
        this(s.productId, s.productName, s.description, s.category, s.price, s.stockQuantity, s.image, s.until);
    }
    
    public Fruit(int id){
        this(FruitDB.getFruit(id));
    }
    
   

    public int addNew(){
        return FruitDB.newFruit(this);
    }

    public Fruit update(){
        return FruitDB.update(this);
    }
    
    public int delete(){
        return FruitDB.delete(this.productId);
    }
}
