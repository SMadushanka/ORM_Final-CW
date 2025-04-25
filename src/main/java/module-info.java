module lk.ijse.orm.ormh {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.jfoenix;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    opens lk.ijse.orm.ormh to javafx.fxml;
    opens lk.ijse.orm.ormh.config to jakarta.persistence;
    opens lk.ijse.orm.ormh.entity to org.hibernate.orm.core;
    opens lk.ijse.orm.ormh.controller to javafx.fxml;
    opens lk.ijse.orm.ormh.tm to javafx.base;
    opens lk.ijse.orm.ormh.dto to javafx.base;

    exports lk.ijse.orm.ormh;
}