package fileupload.fileuploadspring.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "files")
public class Files {
    @Id
    @GeneratedValue()
    int fno;

    String filename;
    String fileOriName;
    String fileurl;
}
