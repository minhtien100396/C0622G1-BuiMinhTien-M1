package ss4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_stop_watch;

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public  StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public long start (){
        return this.startTime =System.currentTimeMillis();
    }
    public long stop(){
        return this.endTime=System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return this.endTime - this.startTime;
    }
}
