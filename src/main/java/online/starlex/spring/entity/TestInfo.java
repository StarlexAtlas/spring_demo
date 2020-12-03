package online.starlex.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "test_info")
public class TestInfo {
    @Id
    @Column(name = "test_id", columnDefinition = "int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testId;
    @Column(name = "test_name", columnDefinition = "varchar(50)")
    private String testName;
    @Column(name = "test_password", columnDefinition = "varchar(50)")
    private String password;
    @Column(name = "test_info", columnDefinition = "varchar(50)")
    private String testInfo;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTestInfo() {
        return testInfo;
    }

    public void setTestInfo(String testInfo) {
        this.testInfo = testInfo;
    }
}
