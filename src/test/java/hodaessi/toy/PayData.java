package hodaessi.toy;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PayData {
    private LocalDate billingDate;
    private int payAmount;
}
