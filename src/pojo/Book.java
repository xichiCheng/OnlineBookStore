package pojo;

import java.math.BigDecimal;

public class Book {
    private Integer id;
    private String name;
    private  String author;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private String imgPath="static/img/default.jpg";
    private String profile;
    private String type;

    public Book() {
    }

    public Book(Integer id, String name, String author, BigDecimal price, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        if(sales==null) {
            this.sales = 0;
        }else {
            this.sales=sales;
        }
        this.stock = stock;
        if(imgPath!=null&& !imgPath.isEmpty())
            this.imgPath = imgPath;
    }

    public Book(Integer id, String name, String author, BigDecimal price, Integer sales, Integer stock, String imgPath, String profile, String type) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        if(sales==null) {
            this.sales = 0;
        }else {
            this.sales=sales;
        }
        this.stock = stock;
        if(imgPath!=null&& !imgPath.isEmpty())
            this.imgPath = imgPath;

        this.profile = profile;
        this.type = type;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                ", profile='" + profile + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
