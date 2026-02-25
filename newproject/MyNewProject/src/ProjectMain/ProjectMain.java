package ProjectMain;

import Controller.Controller;
import Model.Model;
import View.ImageView;

public class ProjectMain {
    public static void main(String[] args) {
        // إنشاء الـ Model
        Model model = new Model();

        // إنشاء الـ View
        ImageView view = new ImageView();

        // إنشاء الـ Controller وربطه بالـ Model والـ View
         new Controller(model, view);

        // إظهار الواجهة
        System.out.println("Program is running successfully!");
        view.setVisible(true);
    }
}
