package com.example.new_mobile_project.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import com.example.new_mobile_project.Models.CustomerModel;
import com.example.new_mobile_project.Models.ProductModel;
import com.example.new_mobile_project.Models.ProductsSellingCount;
import com.example.new_mobile_project.Models.ReportModel;
import com.example.new_mobile_project.Models.feedback_model;
import com.example.new_mobile_project.R;

import java.util.ArrayList;
import java.util.List;

public class EcommerceDatabase extends SQLiteOpenHelper {

    private static String DbName = "ecommereDB";
    SQLiteDatabase ecommerceDatabase;
    public EcommerceDatabase(Context context){
        super(context,DbName,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table customers(custid integer primary key," + "custname text not null,username text not null,password text not null,gender text not null,birthdate text not null,job text not null)");

        db.execSQL("create table orders(ordid integer primary key," + "orddate text not null,custid integer not null,price integer not null," + "FOREIGN KEY (custid) REFERENCES customers(id))");

        db.execSQL("create table orderDetails(orderID integer not null,productID integer not null,quntity integer,primary key(orderID,productID)," + " foreign key(orderID) references orders(ordid)," + "foreign key(productID) references products(proID))");

        db.execSQL("create table products(proID integer primary key, proName text not null, proPrice integer not null," + "proQuantity integer,prodescription text not null ,productQrcode text ,cat_id integer not null, foreign key(cat_id) references categories(catID))");
        db.execSQL("create table categories(catID integer primary key, catName text not null)");
        db.execSQL("create table cartproducts (productid integer not null, productname text not null, productprice text not null, " + "productdescription text not null,productquantity integer not null )");
        db.execSQL("Create table carts(cartID integer primary key autoincrement,custId integer,FOREIGN KEY(custId) REFERENCES customers (CustID))");
        db.execSQL("Create table cartItems(cartid integer not null,prodID integer not null,quantity integer not null,FOREIGN KEY(cartid) REFERENCES carts (cartID),FOREIGN KEY(prodID) REFERENCES products (prodID),Primary key(cartid,prodID))");
        db.execSQL("create table feedbacktable(feedbackid integer primary key," + "feedstring text not null,rating text not null);");
        db.execSQL("create table chartproducts (productid integer not null, productname text not null, productprice text not null, " + "productdescription text not null,productquantity integer not null )");


        ContentValues cat1 = new ContentValues();
        cat1.put("catName","Mobile");
        db.insert("categories",null,cat1);
        ContentValues cat2 = new ContentValues();
        cat1.put("catName","SunBlock");
        db.insert("categories",null,cat2);
        ContentValues cat3 = new ContentValues();
        cat1.put("catName","Perfumes");
        db.insert("categories",null,cat3);

        ContentValues p1 = new ContentValues();
        p1.put("proName","Apple iPhone 12");
        p1.put("proPrice","25000");
        p1.put("proQuantity","2");
        p1.put("prodescription","Dual SIM Mobile - 6.2 inches, 255 GB, 8 GB RAM, 5G - White");
        p1.put("cat_id","1");
        db.insert("products",null,p1);

        ContentValues p2 = new ContentValues();
        p2.put("proName","Samsung Note20");
        p2.put("proPrice","18000");
        p2.put("proQuantity","1");
        p2.put("prodescription"," Dual SIM - 256GB, 8GB RAM, 4G LTE - Black");
        p2.put("cat_id","1");
        db.insert("products",null,p2);

        ContentValues p3 = new ContentValues();
        p3.put("proName","Oppo f9");
        p3.put("proPrice","5000");
        p3.put("proQuantity","3");
        p3.put("prodescription"," Pro Max 64GB 6 GB RAM, Purple");
        p3.put("cat_id","1");
        db.insert("products",null,p3);


        ContentValues p11 = new ContentValues();
        p11.put("proName","Bioderma");
        p11.put("proPrice","380");
        p11.put("proQuantity","4");
        p11.put("prodescription","Tinted to protect skin 40 ml");
        p11.put("cat_id","2");
        db.insert("products",null,p11);

        ContentValues p12 = new ContentValues();
        p12.put("proName","Vichy");
        p12.put("proPrice","340");
        p12.put("proQuantity","2");
        p12.put("productQrcode","3337871325787");
        p12.put("prodescription","Capital Solelil 50 ml ");
        p12.put("cat_id","2");
        db.insert("products",null,p12);

        ContentValues p13 = new ContentValues();
        p13.put("proName","Bobai Gel");
        p13.put("proPrice","150");
        p13.put("proQuantity","10");
        p13.put("prodescription"," Fluid and sunscreen high protection");
        p13.put("cat_id","2");
        db.insert("products",null,p13);

        ContentValues p21 = new ContentValues();
        p21.put("proName","GUCCI");
        p21.put("proPrice","7300");
        p21.put("proQuantity","6");
        p21.put("prodescription","Female GUCCI - Women Day 100ml");
        p21.put("cat_id","3");
        db.insert("products",null,p21);

        ContentValues p22 = new ContentValues();
        p22.put("proName","My way");
        p22.put("proPrice","550");
        p22.put("proQuantity","3");
        p22.put("prodescription"," Sugary Perfume with 60ml");
        p22.put("cat_id","3");
        db.insert("products",null,p22);

        ContentValues p23 = new ContentValues();
        p23.put("proName","TOM FORD");
        p23.put("proPrice","43000");
        p23.put("proQuantity","3");
        p23.put("prodescription","BeITTER PEACH , Eau de parfum 50ml");
        p23.put("cat_id","3");
        db.insert("products",null,p23);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists customers");
        db.execSQL("drop table if exists orders");
        db.execSQL("drop table if exists categories");
        db.execSQL("drop table if exists products");
        db.execSQL("drop table if exists orderDetails");
        db.execSQL("drop table if exists cartproducts");
        onCreate(db);
    }


    public void customerSignUp(CustomerModel customer){
        ContentValues values = new ContentValues();
        values.put("custname",customer.getName());
        values.put("username",customer.getUsername());
        values.put("password",customer.getPassword());
        values.put("birthdate",customer.getBirthdate());
        values.put("job",customer.getJob());
        values.put("gender",customer.getGender());
        ecommerceDatabase = getWritableDatabase();
        ecommerceDatabase.insert("customers",null,values);
        ecommerceDatabase.close();
    }

    public Cursor customerlogin(String userName, String password){
        ecommerceDatabase = getReadableDatabase();
        String [] args = {userName,password};
        Cursor cursor = ecommerceDatabase.rawQuery("select custid from customers where username=? and password =?",args);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }
        ecommerceDatabase.close();
        return cursor;
    }
    public List<ProductsSellingCount> getAllProductsSoldCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorProducts = db.rawQuery("SELECT * from chartproducts" ,null);
        List<ProductsSellingCount> products= new ArrayList<>();
        if(cursorProducts.moveToFirst()){
            do{
                products.add(new ProductsSellingCount(cursorProducts.getString(1),cursorProducts.getInt(4)));
            }while(cursorProducts.moveToNext());
        }
        cursorProducts.close();
        return products;
    }
    public String recoverPassword(String username){
        ecommerceDatabase = getReadableDatabase();
        String[] arg = {username};
        Cursor cursor = ecommerceDatabase.rawQuery("select password from customers where username =?",arg);
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            ecommerceDatabase.close();
            return cursor.getString(0);
        }
        ecommerceDatabase.close();
        cursor.close();
        return null;
    }

    public Cursor getProducts(String catid){
        ecommerceDatabase = getReadableDatabase();
        String [] args = {catid};
        Cursor cursor = ecommerceDatabase.rawQuery("select * from products where cat_id like? ",args);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }
        ecommerceDatabase.close();
        return cursor;
    }

    public void cartProducts(ProductModel cart){
        ContentValues row = new ContentValues();
        row.put("productid",cart.getId());
        row.put("productname",cart.getName());
        row.put("productprice",cart.getPrice());
        row.put("productdescription",cart.getDescription());
        row.put("productquantity",cart.getQuantity());
        ecommerceDatabase = getWritableDatabase();
        ecommerceDatabase.insert("cartproducts",null,row);
        ecommerceDatabase.close();
    }
    public void chartProducts(ProductModel cart){
        ContentValues row = new ContentValues();
        row.put("productid",cart.getId());
        row.put("productname",cart.getName());
        row.put("productprice",cart.getPrice());
        row.put("productdescription",cart.getDescription());
        row.put("productquantity",cart.getQuantity());
        ecommerceDatabase = getWritableDatabase();
        ecommerceDatabase.insert("chartproducts",null,row);
        ecommerceDatabase.close();
    }
    public Cursor getproductquantity(int id){
        ecommerceDatabase = getReadableDatabase();
        String [] args = {String.valueOf(id)};
        Cursor cursor = ecommerceDatabase.rawQuery("select proQuantity from products where proID like? ",args);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }
        ecommerceDatabase.close();
        return cursor;
    }
    public Cursor getCartProducts(){
        ecommerceDatabase = getReadableDatabase();

        String [] rowDetails = {"productid","productname","productprice","productdescription","productquantity"};
        Cursor cursor = ecommerceDatabase.query("cartproducts",rowDetails,null,null,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }
        ecommerceDatabase.close();
        return cursor;
    }

    public Cursor searchProducts(String name){
        ecommerceDatabase = getReadableDatabase();

        String[] args = {"%"+name+"%"};
        Cursor cursor = ecommerceDatabase.rawQuery("select * from products where proName like?",args);

        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            ecommerceDatabase.close();
            return cursor;
        }
        ecommerceDatabase.close();
        return null;

    }

    public void add(String name, String desc, int proprice, int proquantity, int cat_id) {
        ContentValues product_added = new ContentValues();
        product_added.put("proName", name);
        product_added.put("proPrice", proprice);
        product_added.put("proQuantity", proquantity);
        product_added.put("prodescription", desc);
        product_added.put("cat_id", cat_id);
        ecommerceDatabase = getWritableDatabase();
        ecommerceDatabase.insert("products", null, product_added);
        ecommerceDatabase.close();
    }
    public Cursor getcusid(String CustomerUsername){
        ecommerceDatabase = getReadableDatabase();
        String [] args = {CustomerUsername};
        Cursor cursor = ecommerceDatabase.rawQuery("select * from customers where username like? ",args);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }
        ecommerceDatabase.close();
        return cursor;
    }
    public void cartproductsdeletion(){
        ecommerceDatabase = getWritableDatabase();
        ecommerceDatabase.delete("cartproducts", null, null);
        ecommerceDatabase.close();
    }
    public void addorder(int orid, String date, int cusid, int price) {
        ContentValues orderadded = new ContentValues();
        orderadded.put("ordid", orid);
        orderadded.put("orddate", date);
        orderadded.put("custid", cusid);
        orderadded.put("price", price);
        ecommerceDatabase = getWritableDatabase();
        ecommerceDatabase.insert("orders", null, orderadded);
        ecommerceDatabase.close();
    }

    public void update(String old, String newpro, String newdesc, int newprice, int newquant) {
        ecommerceDatabase = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("proName", newpro);
        value.put("prodescription", newdesc);
        value.put("proPrice", newprice);
        value.put("proQuantity", newquant);
        ecommerceDatabase.update("products", value, "proName like ?", new String[]{old});
        ecommerceDatabase.close();
    }
    public void addfeed(String feedstring, String rating) {
        ContentValues feed_added = new ContentValues();
        feed_added.put("feedstring", feedstring);
        feed_added.put("rating", rating);
        ecommerceDatabase = getWritableDatabase();
        ecommerceDatabase.insert("feedbacktable", null, feed_added);
        ecommerceDatabase.close();
    }
    public int getNumOfOrders(){
       ecommerceDatabase = getWritableDatabase();
        Cursor c=ecommerceDatabase.rawQuery("select * from orders" , null);
        return c.getCount();
    }
    public List<ReportModel> getAllReports(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorReports = db.rawQuery("SELECT * FROM orders",null);
        List<ReportModel> reports= new ArrayList<>();
        if(cursorReports.moveToFirst()){
            do{
                reports.add(new ReportModel(cursorReports.getInt(0),
                        cursorReports.getString(1),
                        cursorReports.getInt(2),
                        cursorReports.getInt(3)));
            }while(cursorReports.moveToNext());
        }
        cursorReports.close();
        return reports;
    }
    public ArrayList<String> showmyproducts() {
        ArrayList<String> lista = new ArrayList<>();
        ecommerceDatabase = getReadableDatabase();
        String[] productneeded = {"proName", "prodescription", "proPrice", "proQuantity"};
        Cursor cursor = ecommerceDatabase.query("products", productneeded, null, null, null, null, null);
        while (cursor.moveToNext()) {
            lista.add(cursor.getString(0));
        }
        ecommerceDatabase.close();
        return lista;
    }
    public String getdesc(String name) {
        ecommerceDatabase = getReadableDatabase();
        String code = "";
        Cursor newdesc = ecommerceDatabase.rawQuery("select * from products where proName=? ", new String[]{name});
        if (newdesc.getCount() > 0) {

            newdesc.moveToFirst();
            code = newdesc.getString(4);
        }
        return code;
    }
    public String getprice(String name) {
        ecommerceDatabase = getReadableDatabase();
        String code = "";
        Cursor newdesc = ecommerceDatabase.rawQuery("select * from products where proName=? ", new String[]{name});
        if (newdesc.getCount() > 0) {

            newdesc.moveToFirst();
            code = newdesc.getString(2);
        }
        return code;
    }
    public String getquantity(String name) {
        ecommerceDatabase = getReadableDatabase();
        String code = "";
        Cursor newdesc = ecommerceDatabase.rawQuery("select * from products where proName=? ", new String[]{name});
        if (newdesc.getCount() > 0) {

            newdesc.moveToFirst();
            code = newdesc.getString(3);
        }
        return code;
    }
    public void delete(String name) {
        ecommerceDatabase = getWritableDatabase();
        ecommerceDatabase.delete("products", "proName='" + name + "'", null);
        ecommerceDatabase.close();
    }
    public ArrayList<feedback_model> showmyfeeds() {
        String query = "SELECT feedstring,rating FROM feedbacktable";
        ArrayList<feedback_model> feedadapter = new ArrayList<feedback_model>();
        ecommerceDatabase = getReadableDatabase();
        Cursor c = ecommerceDatabase.rawQuery(query,null);
        if(c != null){
            while (c.moveToNext()){
                vv(c,feedadapter);
            }
        }
        return feedadapter;
    }
    public void vv(Cursor c , ArrayList<feedback_model> feedback )
    {
        @SuppressLint("Range") String feedtxt = c.getString(c.getColumnIndex("feedstring"));
        @SuppressLint("Range") String feedrate = c.getString(c.getColumnIndex("rating"));
        feedback_model feed = new feedback_model();
        feed.setFeedtxt(feedtxt);
        feed.setFeedrate(feedrate);
        feedback.add(feed);

    }
    public Cursor SearchBarcode(String Barcode){
        ecommerceDatabase = getReadableDatabase();

        String[] args = {Barcode};
        Cursor cursor = ecommerceDatabase.rawQuery("select * from products where productQrcode like?",args);

        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            ecommerceDatabase.close();
            return cursor;
        }
        ecommerceDatabase.close();
        return null;

    }
    public void deleteCartProducts(String productName){
        ecommerceDatabase = getWritableDatabase();
        ecommerceDatabase.delete("cartproducts","productname = '"+productName+"'",null);
        ecommerceDatabase.close();
    }

}
