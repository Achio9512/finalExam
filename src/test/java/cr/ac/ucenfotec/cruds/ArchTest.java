package cr.ac.ucenfotec.cruds;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("cr.ac.ucenfotec.cruds");

        noClasses()
            .that()
                .resideInAnyPackage("cr.ac.ucenfotec.cruds.service..")
            .or()
                .resideInAnyPackage("cr.ac.ucenfotec.cruds.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..cr.ac.ucenfotec.cruds.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
