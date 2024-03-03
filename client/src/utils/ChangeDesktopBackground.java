package utils;

import java.io.IOException;

public class ChangeDesktopBackground {
	private String newWallpaperPath;
	
	public ChangeDesktopBackground(String newWallpaperPath) {
		System.out.println("PATH: " + newWallpaperPath);
		this.newWallpaperPath = newWallpaperPath;
	}
    public void changeDesktop() {
        try {
            // Sử dụng lệnh của hệ điều hành để thay đổi hình nền
            String cmd = "reg add \"HKEY_CURRENT_USER\\Control Panel\\Desktop\" /v Wallpaper /t REG_SZ /d \"" + newWallpaperPath + "\" /f";
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
            if (process.exitValue() == 0) {
                // Áp dụng hình nền mới
                Runtime.getRuntime().exec("rundll32.exe user32.dll, UpdatePerUserSystemParameters");
                // Thông báo thành công
                System.out.println("Đã thay đổi hình nền thành công.");
            } else {
                // Thông báo lỗi nếu có
                System.err.println("Thay đổi hình nền thất bại. Có lỗi xảy ra.");
            }
        } catch (IOException | InterruptedException e) {
            // Xử lý ngoại lệ nếu có
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//		new ChangeDesktopBackground("C:\\Users\\HAIZUKA\\Downloads\\background_.jpg").changeDesktop();
		new ChangeDesktopBackground("G:\\remote-screen-control\\client\\background.jpg").changeDesktop();
	}
}