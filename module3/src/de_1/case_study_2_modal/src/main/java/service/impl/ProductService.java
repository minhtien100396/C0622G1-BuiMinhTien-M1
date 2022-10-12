package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;
import validation.Validation;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> selectAllProduct() {
        return productRepository.selectAllProduct();
    }

    @Override
    public List<Product> search(String searchName, String searchPrice) {
        return productRepository.search(searchName, searchPrice);
    }

    @Override
    public List<Product> search(String searchName) {
        return productRepository.search(searchName);
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return productRepository.deleteProduct(id);
    }

    @Override
    public Map<String, String> insertProduct(Product product) throws SQLException {
        Map<String, String> errorMap = new HashMap<>();
//        if (product.getName().equals("")) {
//            errorMap.put("name", "Tên Sản Phẩm không được để trống!");
//        } else if (!Validation.checkName(product.getName())) {
//            errorMap.put("name", "Tên Sản Phẩm không đúng định dạng");
//        }
//        if (product.getPrice().equals("")) {
//            errorMap.put("price", "Giá không được để trống!");
//        }else if (Integer.parseInt(product.getPrice()) < 10000000){
//            errorMap.put("price", "Giá phải lớn hơn 10.000.000 VNĐ");
//        }
//        if (product.getQuantity().equals("")) {
//            errorMap.put("quantity", "Số lượng không được để trống!");
//        }else if (Integer.parseInt(product.getQuantity()) > 0){
//            errorMap.put("price", "Số lượng phải là số nguyên dương");
//        }



//        if (phongTro.getPhoneNumber().equals("")) {
//            errorMap.put("phoneNumber", "Số Điện Thoại không được để trống!");
//        } else if (!Validation.checkPhone(phongTro.getPhoneNumber())) {
//            errorMap.put("phoneNumber", "Số Điện Thoại không đúng định dạng (XX)-(0XXXXXXXXX)");
//        }
//        if (phongTro.getIdThanhToan() == 100) {
//            errorMap.put("idThanhToan", "Hình Thức Thanh Toán không được để trống!");
//        }
//
//        if (phongTro.getDateBegin().equals("")) {
//            errorMap.put("dateBegin", "Ngày Bắt Đầu Thuê Trọ không được để trống!");
//        } else {
//            if (LocalDate.parse(phongTro.getDateBegin()).isAfter(LocalDate.now())) {
//                errorMap.put("dateBegin", "Ngày Bắt Đầu Thuê Trọ không hợp lệ (Phải Nhỏ Hơn Ngày Hiện Tại)");
//            }
//        }
        if (errorMap.size() == 0) {
            productRepository.insertProduct(product);
        }
        return errorMap;
    }

    @Override
    public Map<Integer, String> selectAllCategory() {
        return productRepository.selectAllCategory();
    }
}
