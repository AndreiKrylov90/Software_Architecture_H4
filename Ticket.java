import java.text.SimpleDateFormat;
import java.util.Date;

class Ticket {

    static int counter = 4000;

    public Ticket() {
        id = ++counter;
    }

    private int id;
    private int customerId;
    private Date date;
    private String qrcode = String.valueOf(Integer.toHexString(id));

    private boolean enable = true;

    public int getId() {
        return id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getQrcode() {
        return qrcode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + id +
                "\nCustomer ID: " + customerId;
    }

}
