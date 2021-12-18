package model;

import java.util.List;

public class PageBean {
    private Integer rows;//共有几行
    private Integer currPage;//当前页码
    private int count;//每页的条数
    private  List<Food> foods;
    public PageBean(Integer rows, Integer currPage, int count, List<Food> foods) {
        this.rows = rows;
        this.currPage = currPage;
        this.count = count=5;
        this.foods = foods;
    }

    public PageBean() {
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "rows=" + rows +
                ", currPage=" + currPage +
                ", count=" + count +
                ", foods=" + foods +
                '}';
    }



    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }


}
