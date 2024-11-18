package org.oz.locale24_store_back.localmaneger.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.oz.locale24_store_back.area.domain.AreaCode;
import org.oz.locale24_store_back.common.domain.BasicEntity;

@Entity
@Table(name = "store_local_manager")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocalManager extends BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_no")
    private Long managerNo;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "manager_contact")
    private String managerContact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_name", referencedColumnName = "area_name")
    private AreaCode areaCode;
}