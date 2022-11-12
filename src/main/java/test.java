import com.alibaba.fastjson.JSONObject;
import org.mortbay.util.ajax.JSON;

public class test {
    public static void main(String[] args) {


        String s="{\"INFO\":" +
                "{\"TRX_CODE\":\"100014\",\"VERSION\":\"04\",\"DATA_TYPE\":\"2\",\"REQ_SN\":\"Test68190\",\"RET_CODE\":\"0000\",\"ERR_MSG\":\"处理成功\",\"SIGNED_MSG\":\"a0023b70381d112c0b74f332b7300d3fcfdc8dc46a385f52024227eda6dfab30d997b4a9dbee845fd49dce6013a16dcaf139546f3db1a666ff15acb42c2b12e8e9417f2f9031cc6b1791e481e4c4b4817a87628b185440cc52e0b4cd12190eb451a9c8be75a41511e74a9c7abe50f26c58539bca921546a98c41c2fc7938320ef1884ed417a35eb64bd9c2ce9962646996f20604530af8a7506aef59dbe425db13369b4386649f29d5e51d880c6cc0e0ba02c137f8662f7e734631d8ddd8781521590188f0e27fcfb10829b99d73042c5279c0831b0fb9be6dfd03a7020f8cecf93abc16963c881b17b49076403846db0ccf92c9dd12586428e4570d04a427ba\"},\"TRANSRET\":{\"RET_CODE\":\"0000\",\"SETTLE_DAY\":\"20180705\",\"ERR_MSG\":\"处理成功\"}}";

        JSONObject jsonObject =com.alibaba.fastjson.JSONObject.parseObject("{\"boolean\":true,\"string\":\"string\",\"list\":[1,2,3],\"int\":2}");
        String str=jsonObject.getString("boolean");
        System.out.println(str);

    }
}
