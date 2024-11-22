package org.oz.locale24_store_back.product.domain;

import jakarta.persistence.*;
import lombok.*;
import org.oz.locale24_store_back.common.domain.AttachFile;
import org.oz.locale24_store_back.common.domain.BasicEntity;
import org.oz.locale24_store_back.event.domain.EventEntity;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "event_product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"attachFiles", "event"})
public class ProductEntity extends BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_product_no", nullable = false)
    private Long pno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_no", referencedColumnName = "event_no")
    private EventEntity event;

    @Column(name = "product_code")
    private Long pcode;

    @Column(name = "product_name")
    private String pname;

    @Column(name = "product_price")
    private int price;

    @Column(name = "product_description")
    private String pdesc;

    private int quantity;

    @ElementCollection
    @Builder.Default
    @CollectionTable(
            name = "event_product_file",
            joinColumns = @JoinColumn(name = "event_product_no")
    )
    private Set<AttachFile> attachFiles = new HashSet<>();

    public void addFile(String fileName) {

        attachFiles.add(new AttachFile(attachFiles.size(), fileName));
    }

    public void removeFiles() {
        attachFiles.clear();
    }

}
