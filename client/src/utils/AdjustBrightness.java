package utils;

import java.io.IOException;

public class AdjustBrightness {
    private int brightnessLevel;

    public AdjustBrightness(int brightnessLevel) {
        this.brightnessLevel = brightnessLevel;
    }

    public void adjustBrightness() {
        try {
            // Sử dụng PowerShell để điều chỉnh độ sáng màn hình
            String cmd = "powershell.exe (Get-WmiObject -Namespace root/WMI -Class WmiMonitorBrightnessMethods).WmiSetBrightness(1, " + brightnessLevel + ")";
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
            if (process.exitValue() == 0) {
                // Thông báo thành công
                System.out.println("Đã điều chỉnh độ sáng màn hình thành công.");
            } else {
                // Thông báo lỗi nếu có
                System.err.println("Điều chỉnh độ sáng màn hình thất bại. Có lỗi xảy ra.");
            }
        } catch (IOException | InterruptedException e) {
            // Xử lý ngoại lệ nếu có
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Điều chỉnh độ sáng màn hình (ví dụ: giảm 50%)
        new AdjustBrightness(100).adjustBrightness();
    }
}

