package repository;

import entity.HoKhau;
import entity.HoKhauNhanKhau;
import entity.NhanKhau;
import javafx.collections.ObservableList;
import utility.DbUtil;
import utility.SQLCommand;
import javafx.collections.FXCollections;

import java.sql.*;

public class HoKhauRepositoryImpl implements HoKhauRepository{
    private ResultSet rs = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private CallableStatement cstmt = null;
    private Connection conn = null;

    @Override
    public int tongHoKhau(){
        int tongHoKhau=0;
        try {
            conn = DbUtil.getInstance().getConnection();
            pstmt = conn.prepareStatement(SQLCommand.HO_KHAU_QUERY_TONG);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                tongHoKhau = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtil.releaseResource(rs, stmt, pstmt, cstmt, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tongHoKhau;
    }

    //ThemHoKhauController
    @Override
    public boolean check_chu_ho(int id_nk){
        try {
            conn = DbUtil.getInstance().getConnection();
            pstmt = conn.prepareStatement(SQLCommand.HO_KHAU_QUERY_LAY_THONG_TIN);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                int idChuHo = rs.getInt("idChuHo");
                if(idChuHo == id_nk) return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                DbUtil.releaseResource(rs, stmt, pstmt, cstmt, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

}
