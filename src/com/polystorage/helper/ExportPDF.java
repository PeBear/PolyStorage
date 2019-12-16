package com.polystorage.helper;

import java.io.FileOutputStream;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.polystorage.dao.DonNhapDAO;
import com.polystorage.dao.DonXuatDAO;
import com.polystorage.entity.ChiTietDonNhap;
import com.polystorage.entity.ChiTietDonXuat;
import com.polystorage.entity.DonNhap;
import com.polystorage.entity.DonXuat;
import com.polystorage.entity.KhachHang;
import com.polystorage.entity.NhaCungCap;
import com.polystorage.entity.SanPham;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ExportPDF {

    public String FILE;
    private static Font arialNormal;
    private static Font arialBold;
    private static Font arialItalic;

    public ExportPDF() {
        try {
            BaseFont bf = BaseFont.createFont("font/vuArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            arialNormal = new Font(bf, 13);
            bf = BaseFont.createFont("font/vuArialBold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            arialBold = new Font(bf, 13);
            bf = BaseFont.createFont("font/vuArialItalic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            arialItalic = new Font(bf, 13);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public static void main(String[] args) {
//        try {
//
//            File file = new File(FILE);
//            file.delete();
//            if (file.createNewFile()) {
//                System.out.println("create file");
//            }
//
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream(FILE));
//            document.open();
//            //addMetaData(document);
//            //addTitlePage(document);
//            //addContent(document);
//            document.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void exportDonNhap(DonNhap donNhap) {
        try {
            File file = new File(FILE);
            if (file.createNewFile()) {
                System.out.println("create file");
            }
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            getTemplateDonNhap(document, donNhap);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportDonXuat(DonXuat donXuat) {
        try {
            File file = new File(FILE);
            if (file.createNewFile()) {
                System.out.println("create file");
            }
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            getTemplateDonXuat(document, donXuat);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
    }

    private void getTemplateDonNhap(Document document, DonNhap donNhap)
            throws DocumentException {
        Paragraph title = new Paragraph();
        title.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(title, 1);
        title.add(new Paragraph("PHIẾU NHẬP KHO", arialBold));

        //get day month year
        Date ngayNhap = donNhap.getNgayNhap();
        LocalDate localDate = ngayNhap.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        title.add(new Paragraph("Ngày " + day + " tháng " + month + " năm " + year, arialNormal));
        title.add(new Paragraph("Số đơn: " + donNhap.getMaDN(), arialNormal));
        addEmptyLine(title, 1);

        Paragraph content = new Paragraph();
        // Will create: Report generated by: _name, _date
        NhaCungCap nhaCungCap = donNhap.getNhaCungCap();
        content.add(new Paragraph("Nhà cung cấp: " + nhaCungCap.getTenNCC(), arialNormal));
        content.add(new Paragraph("Số điện thoại: " + nhaCungCap.getSdt(), arialNormal));
        content.add(new Paragraph("Email: " + nhaCungCap.getEmail(), arialNormal));
        content.add(new Paragraph("Địa chỉ: " + nhaCungCap.getDiaChi(), arialNormal));
        addEmptyLine(content, 1);

        Paragraph subPara = new Paragraph("", arialNormal);
        subPara = createTable(donNhap);
        addEmptyLine(subPara, 1);

        Paragraph footer = new Paragraph();

        footer.add(new Paragraph("Tổng số tiền:" + ProcessString.toVietnamMoney(new DonNhapDAO().getTongDonNhap(donNhap.getMaDN())) + " VNĐ", arialBold));

        document.add(title);
        document.add(content);
        document.add(subPara);
        document.add(footer);// Start a new page
        //document.newPage();
    }

    private void getTemplateDonXuat(Document document, DonXuat donXuat)
            throws DocumentException {
        Paragraph title = new Paragraph();
        title.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(title, 1);
        title.add(new Paragraph("PHIẾU XUẤT KHO", arialBold));
        //get day month year
        Date ngayXuat = donXuat.getNgayXuat();
        LocalDate localDate = ngayXuat.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        title.add(new Paragraph("Ngày " + day + " tháng " + month + " năm " + year, arialNormal));
        title.add(new Paragraph("Số đơn: " + donXuat.getMaDX(), arialNormal));
        addEmptyLine(title, 1);

        Paragraph content = new Paragraph();
        // Will create: Report generated by: _name, _date
        KhachHang khachHang = donXuat.getKhachHang();
        content.add(new Paragraph("Khách hàng: " + khachHang.getHoTen(), arialNormal));
        content.add(new Paragraph("Số điện thoại: " + khachHang.getSdt(), arialNormal));
        content.add(new Paragraph("Email: " + khachHang.getEmail(), arialNormal));
        content.add(new Paragraph("Địa chỉ: " + khachHang.getDiaChi(), arialNormal));
        addEmptyLine(content, 1);

        Paragraph subPara = new Paragraph("", arialNormal);
        subPara = createTable(donXuat);
        addEmptyLine(subPara, 1);

        Paragraph footer = new Paragraph();

        footer.add(new Paragraph("Tổng số tiền:" + ProcessString.toVietnamMoney(new DonXuatDAO().getTongDonXuat(donXuat.getMaDX())) + " VNĐ", arialBold));

        document.add(title);
        document.add(content);
        document.add(subPara);
        document.add(footer);// Start a new page
        //document.newPage();
    }

//    private static void addContent(Document document) throws DocumentException {
//        Anchor anchor = new Anchor("First Chapter", arialNormal);
//        anchor.setName("First Chapter");
//
//        // Second parameter is the number of the chapter
//        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
//
//        Paragraph subPara = new Paragraph("Subcategory 1", arialNormal);
//        Section subCatPart = catPart.addSection(subPara);
//        subCatPart.add(new Paragraph("Hello"));
//
//        subPara = new Paragraph("Subcategory 2", arialNormal);
//        subCatPart = catPart.addSection(subPara);
//        subCatPart.add(new Paragraph("Paragraph 1"));
//        subCatPart.add(new Paragraph("Paragraph 2"));
//        subCatPart.add(new Paragraph("Paragraph 3"));
//
//        // add a list
//        createList(subCatPart);
//        Paragraph paragraph = new Paragraph();
//        addEmptyLine(paragraph, 5);
//        subCatPart.add(paragraph);
//
//        // add a table
//        createTable(subCatPart);
//
//        // now add all this to the document
//        document.add(catPart);
//
//        // Next section
//        anchor = new Anchor("Second Chapter", catFont);
//        anchor.setName("Second Chapter");
//
//        // Second parameter is the number of the chapter
//        catPart = new Chapter(new Paragraph(anchor), 1);
//
//        subPara = new Paragraph("Subcategory", subFont);
//        subCatPart = catPart.addSection(subPara);
//        subCatPart.add(new Paragraph("This is a very important message"));
//
//        // now add all this to the document
//        document.add(catPart);
//
//    }
    private Paragraph createTable(DonNhap donNhap)
            throws BadElementException {
        Paragraph subCatPart = new Paragraph();
        PdfPTable table = new PdfPTable(5);
        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);
        PdfPCell c1 = new PdfPCell(new Phrase("Mã SP", arialNormal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Tên Sản Phẩm", arialNormal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Số Lượng", arialNormal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Đơn Giá", arialNormal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Thành Tiền", arialNormal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        Set<ChiTietDonNhap> set = donNhap.getChitietdonnhaps();
        List<ChiTietDonNhap> list = new ArrayList<>(set);
        for (ChiTietDonNhap x : list) {
            SanPham sanPham = x.getSanPham();
            int soLuong = x.getSoLuong();
            float donGia = sanPham.getGiaDv();
            table.addCell(sanPham.getMaSp());
            table.addCell(sanPham.getTenSp());
            table.addCell(String.valueOf(soLuong));
            table.addCell(ProcessString.toVietnamMoney(donGia));
            float thanhTien = donGia * soLuong;
            table.addCell(ProcessString.toVietnamMoney(thanhTien));
        }

        subCatPart.add(table);
        return subCatPart;
    }

    private Paragraph createTable(DonXuat donXuat)
            throws BadElementException {
        Paragraph subCatPart = new Paragraph();
        PdfPTable table = new PdfPTable(5);
        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);
        PdfPCell c1 = new PdfPCell(new Phrase("Mã SP", arialNormal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Tên Sản Phẩm", arialNormal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Số Lượng", arialNormal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Đơn Giá", arialNormal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Thành Tiền", arialNormal));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        Set<ChiTietDonXuat> set = donXuat.getChiTietDonXuats();
        List<ChiTietDonXuat> list = new ArrayList<>(set);
        for (ChiTietDonXuat x : list) {
            SanPham sanPham = x.getSanPham();
            int soLuong = x.getSoLuong();
            float donGia = sanPham.getGiaDv();
            table.addCell(sanPham.getMaSp());
            table.addCell(sanPham.getTenSp());
            table.addCell(String.valueOf(soLuong));
            table.addCell(ProcessString.toVietnamMoney(donGia));
            float thanhTien = donGia * soLuong;
            table.addCell(ProcessString.toVietnamMoney(thanhTien));
        }

        subCatPart.add(table);
        return subCatPart;
    }

//    private static void createList(Section subCatPart) {
//        List list = new List(true, false, 10);
//        list.add(new ListItem("First point"));
//        list.add(new ListItem("Second point"));
//        list.add(new ListItem("Third point"));
//        subCatPart.add(list);
//    }
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
