package pl.edu.wszib.erp.specifications;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import pl.edu.wszib.erp.model.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentSpecifications {

    private DocumentSpecifications() {
    }

    public static Specification<Document> documentSpecification(String searchBy) {
        return (root, query, builder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if (searchBy != null) {
                predicateList.add(
                        builder.equal(builder.toString(root.get("id")), searchBy)
                );
                predicateList.add(
                        builder.like(builder.lower(root.get("title")), "%" + searchBy.toLowerCase() + "%")
                );
                predicateList.add(
                        builder.like(builder.lower(root.get("description")), "%" + searchBy.toLowerCase() + "%")
                );
                predicateList.add(
                        builder.like(builder.toString(root.get("createdAt")), "%" + searchBy + "%")
                );
                predicateList.add(
                        builder.like(builder.toString(root.get("updatedAt")), "%" + searchBy + "%")
                );
            }

            return builder.or(predicateList.toArray(new Predicate[]{}));
        };
    }

}
