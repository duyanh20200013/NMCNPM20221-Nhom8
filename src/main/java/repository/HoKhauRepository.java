package repository;
import entity.HoKhau;
import entity.HoKhauNhanKhau;
import entity.NhanKhau;
import javafx.collections.ObservableList;

import java.sql.Date;

public interface HoKhauRepository {
    public int tongHoKhau();

    //ThemHoKhauController
    public boolean check_chu_ho(int id_nk);

}
