package yr.jstl.util;

import java.util.List;

public class PageBean {
    private int countPerPage = 10;
    private int currPageNum;
    private int totalPageNum;
    private int wholeCount;
    private List list;

    public int getCountPerPage() {
        return countPerPage;
    }

    public void setCountPerPage(int countPerPage) {
        this.countPerPage = countPerPage;
    }

    public int getCurrPageNum() {
        return currPageNum;
    }

    public void setCurrPageNum(int currPageNum) {
        this.currPageNum = currPageNum;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public int getWholeCount() {
        return wholeCount;
    }

    public void setWholeCount(int wholeCount) {
        this.wholeCount = wholeCount;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "countPerPage=" + countPerPage +
                ", currPageNum=" + currPageNum +
                ", totalPageNum=" + totalPageNum +
                ", wholeCount=" + wholeCount +
                ", list=" + list +
                '}';
    }
}
