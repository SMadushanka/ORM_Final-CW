package lk.ijse.orm.ormh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDto {
    private int id;
    private Double amount;
    private int patientId;

    public PaymentDto(Double amount, int patientId) {
        this.amount = amount;
        this.patientId = patientId;
    }
}
