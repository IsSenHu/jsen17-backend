package com.jsen17.money.domain.po;

import com.jsen17.jpa.core.BasePO;
import com.jsen17.money.common.enums.BillType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Husen
 * @since 2022/11/28 20:55
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tb_bill_record")
public class BillRecord extends BasePO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column
    private BigDecimal money;

    @Column
    private BillType type;

    @Column
    private String description;

    @Override
    public void fillingDefaultFieldVal() {

    }
}
