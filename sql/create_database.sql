CREATE SCHEMA `test_manage_library` ;
use `test_manage_library`;

create table BanDoc(
	id int not null auto_increment,
    hoTen varchar(255) not null,
    lop varchar(255),
    ngaySinh date,
    diaChi varchar(255),
    soDienThoai varchar(255),
    email varchar(255),
    vaiTro varchar(255) not null,
    kichHoat bit not null,
    primary key (id)
);

create table NhanVienThuVien(
	id int not null auto_increment,
    taiKhoan varchar(255) not null,
    matKhau varchar(255) not null,
    hoTen varchar(255) not null,
    ngaySinh date,
    diaChi varchar(255),
    soDienThoai varchar(255),
    email varchar(255),
    primary key (id)
);

create table LoaiTaiLieu(
	id int not null auto_increment,
    tenLoaiTaiLieu varchar(255) not null,
    moTa varchar(255),
    kichHoat bit not null,
    primary key (id)
);

create table TheBanDoc(
	id int not null auto_increment,
    maThe varchar(255) not null,
    ngayTaoThe date not null,
    ngayHetHan date not null,
    BanDocid int not null,
    primary key (id),
    foreign key (BanDocid) references BanDoc (id)
);

create table TaiLieu(
	id int not null auto_increment,
    tenTaiLieu varchar(255) not null,
    tacGia varchar(255),
    hinhAnh varchar(255),
    nhaXuatBan varchar(255),
    nhaSanXuat varchar(255),
    namXuatBan int,
    chatLieu varchar(255),
    donGia decimal(18,2) not null,
    tongSoLuong int not null,
    kichThuoc varchar(255),
    moTa varchar(255),
    kichHoat bit not null,
    LoaiTaiLieuid int not null,
    primary key (id),
    foreign key (LoaiTaiLieuid) references LoaiTaiLieu (id)
);

create table PhieuMuon(
	id int not null auto_increment,
    ngayMuon date not null,
    BanDocid int not null,
    NhanVienThuVienid int not null,
    primary key (id),
    foreign key (BanDocid) references BanDoc (id),
    foreign key (NhanVienThuVienid) references NhanVienThuVien (id)
);

create table PhieuMuonChiTiet(
	id int not null auto_increment,
    trangThai bit not null,
    TaiLieuid int not null,
    PhieuMuonid int not null,
    primary key (id),
    foreign key (TaiLieuid) references TaiLieu (id),
    foreign key (PhieuMuonid) references PhieuMuon (id)
);

create table PhieuTra(
	id int not null auto_increment,
    ngayTra date not null,
    BanDocid int not null,
    NhanVienThuVienid int not null,
    primary key (id),
    foreign key (BanDocid) references BanDoc (id),
    foreign key (NhanVienThuVienid) references NhanVienThuVien (id)
);

create table PhieuTraChiTiet(
	id int not null auto_increment,
    maSachMuon varchar(255) not null,
    TaiLieuid int not null,
    PhieuTraid int not null,
    primary key (id),
    foreign key (TaiLieuid) references TaiLieu (id),
    foreign key (PhieuTraid) references PhieuTra (id)
);

INSERT INTO nhanvienthuvien (`taiKhoan`, `matKhau`, `hoTen`) VALUES ('admin123', '123456', 'admin');