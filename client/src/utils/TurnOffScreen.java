package utils;

import java.io.IOException;

public class TurnOffScreen {
    private int brightnessLevel;

    public TurnOffScreen(int brightnessLevel) {
        this.brightnessLevel = brightnessLevel;
    }

    public void adjustBrightness() {
        try {
            // Sử dụng PowerShell để điều chỉnh độ sáng màn hình
        	String cmd = "powershell.exe Add-Type -TypeDefinition \"@"
        	        + "using System;"
        	        + "using System.Runtime.InteropServices;"
        	        + "public class PInvoke {"
        	        + "[DllImport(\"user32.dll\")]"
        	        + "public static extern int SendMessage(int hWnd, int hMsg, int wParam, int lParam);"
        	        + "}"
        	        + "@\";"
        	        + "[PInvoke]::SendMessage(0xffff, 0x112, 0xf170, 2);";
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
        new TurnOffScreen(100).adjustBrightness();
    }
}