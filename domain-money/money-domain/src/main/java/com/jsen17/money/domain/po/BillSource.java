package com.jsen17.money.domain.po;

import com.jsen17.jpa.core.BasePO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Husen
 * @since 2022/11/28 21:06
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tb_bill_source")
public class BillSource extends BasePO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String source;

    @Override
    public void fillingDefaultFieldVal() {

    }
}
