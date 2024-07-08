package javaProj;
public class report_class {

    float totalSales;
    String currentNow;


    public report_class(float totSale, String nowTime){
        totalSales = totSale;
        currentNow = nowTime;
    }


    public float getTotalSales() {
        return totalSales;
    }

    public String getCurrentNow() {
        return currentNow;
    }


}
