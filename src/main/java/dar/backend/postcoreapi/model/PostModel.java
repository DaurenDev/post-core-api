package dar.backend.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostModel {
    private String postId;

    @NotNull(message = "ClientID must be filled")
    private String clientId;

    @NotNull(message = "postRecipient must be filled")
    private String postRecipient;

    private String postItem;
    private String status;

}
