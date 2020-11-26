package org.o7planning.android2dgame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
    //một luồng điều khiển việc cập nhật giao diện trò chơi.
public class GameThread extends Thread {
    private boolean running;
    private GameSurface gameSurface;
    private SurfaceHolder surfaceHolder;

    public GameThread(GameSurface gameSurface, SurfaceHolder surfaceHolder)  {
        this.gameSurface= gameSurface;
        this.surfaceHolder= surfaceHolder;
    }

    @Override
    public void run()  {
        long startTime = System.nanoTime();

        while(running)  {
            Canvas canvas= null;
            try {
                // Lấy Canvas từ Holder và khóa nó.
                canvas = this.surfaceHolder.lockCanvas();

                // Đồng bộ hóa
                synchronized (canvas)  {
                    this.gameSurface.update();
                    this.gameSurface.draw(canvas);
                }
            }catch(Exception e)  {
                // Không làm gì cả.
            } finally {
                if(canvas!= null)  {
                    // Unlock Canvas.
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            long now = System.nanoTime() ;
            // Khoảng thời gian để vẽ lại trò chơi
            // (Thay đổi nano giây thành mili giây)
            long waitTime = (now - startTime)/1000000;
            if(waitTime < 10)  {
                waitTime= 10; // Một phần nghìn giây.
            }
            System.out.print(" Wait Time="+ waitTime);

            try {
                // Ngủ.
                this.sleep(waitTime);
            } catch(InterruptedException e)  {

            }
            startTime = System.nanoTime();
            System.out.print(".");
        }
    }

    public void setRunning(boolean running)  {
        this.running= running;
    }
}
