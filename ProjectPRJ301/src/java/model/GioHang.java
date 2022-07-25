/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dal.SachDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author May Tinh Ha Anh
 */
public class GioHang {

    private List<Item> items;

    public GioHang() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItemById(int maSach) {
        for (Item i : items) {
            if (i.getSach().getMaSach() == maSach) {
                return i;
            }
        }
        return null;
    }

    public int getQuantityById(int maSach) //Lay ra so luong trong gio hang cua sach theo ma sach
    {
        return getItemById(maSach).getSoLuong();
    }

    public void addItem(Item t) {
        //Sach da co trong gio hang
        if (getItemById(t.getSach().getMaSach()) != null) {
            Item m = getItemById(t.getSach().getMaSach()); //Tra ve sach da co trong gio hang
            m.setSoLuong(m.getSoLuong() + t.getSoLuong());
        } else //Sach chua co trong gio hang
        {
            items.add(t);
        }
    }

    public void removeItem(int maSach) {
        if (getItemById(maSach) != null) {
            items.remove(getItemById(maSach));
        }
    }

    public int getTotalMoney() {
        int t = 0;
        for (Item i : items) {
            t = t + (i.getSoLuong() * i.getGia());
        }
        return t;
    }

    public Sach getProductById(int maSach, List<Sach> list) {
        for (Sach i : list) {
            if (i.getMaSach() == maSach) {
                return i;
            }
        }
        return null;
    }

    public GioHang(String txt, List<Sach> list) {
        items = new ArrayList<>();//Khoi tao 1 gio hang
        try {
            if (txt != null && txt.length() != 0) //Neu ton tai gio hang
            {
                String[] s = txt.split(",");
                for (String i : s) {
                    String[] n = i.split(":");
                    int maSach = Integer.parseInt(n[0]);
                    int soLuong = Integer.parseInt(n[1]);
                    Sach p = getProductById(maSach, list);
                    Item t = new Item(p, soLuong, p.getGia());
                    addItem(t);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

}
