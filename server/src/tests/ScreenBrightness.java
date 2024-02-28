import com.sun.jna.Library;
import com.sun.jna.Native;

interface User32 extends Library {
    boolean SendMessageTimeoutA(int hWnd, int Msg, int wParam, int lParam, int fuFlags, int uTimeout, int lpdwResult);
}

public class ScreenBrightness {
    public static void main(String[] args) {
        // Độ sáng màn hình mới (giả sử là 50%)
        int brightnessLevel = 50;

        // Gọi hàm giảm độ sáng màn hình
        setScreenBrightness(brightnessLevel);
    }

    public static void setScreenBrightness(int brightnessLevel) {
        try {
            User32 user32 = (User32) Native.loadLibrary("user32", User32.class);

            // Mã hành động để điều chỉnh độ sáng màn hình
            final int SC_MONITORPOWER = 0xF170;
            final int WM_SYSCOMMAND = 0x0112;

            // Tham số cho việc giảm độ sáng màn hình
            final int MONITOR_ON = -1;
            final int MONITOR_OFF = 2;
            final int MONITOR_STANBY = 1;

            // Gửi thông điệp đến hệ thống để điều chỉnh độ sáng màn hình
            user32.SendMessageTimeoutA(MONITOR_ON, WM_SYSCOMMAND, SC_MONITORPOWER, brightnessLevel, 0, 1000, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
