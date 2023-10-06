package com.example.demo.convert;


import com.example.demo.DTO.DataConversionRequest;
import com.example.demo.DTO.DataConversionResponse;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConverterAdapter  {
    StringConverter stringConverter = new StringConverter();
    Base64Converter base64Converter = new Base64Converter();
    HexConverter hexConverter = new HexConverter();


    public Object convert(DataConversionRequest commonData) throws Exception {
        String format = commonData.getFormat();
        String to = commonData.getTo();
        Object data = commonData.getData();
        String result;
            switch (format){
                case "string" :
                    switch (to){
                        case "base64" :
                            result = stringConverter.convertToBase64(data.toString());
                            break;
                        case "hex" :
                            result = stringConverter.convertToHex(data.toString());
                            break;

                        default:
                            return ResponseEntity.badRequest().body(new DataConversionResponse("Chuyển đổi chưa được hỗ trợ"));
                    }
                    break;
                case "base64" :
                    switch (to){
                        case "string" :
                            result = base64Converter.convertToString(data.toString());
                            break;
                        case "hex" :
                            result = base64Converter.convertToHex(data.toString());
                            break;

                        default:
                            return ResponseEntity.badRequest().body(new DataConversionResponse("Chuyển đổi chưa được hỗ trợ"));
                    }
                    break;
                case "hex" :
                    switch (to){
                        case "string" :
                            result = hexConverter.convertToString(data.toString());
                            break;
                        case "base64" :
                            result = hexConverter.convertToBase64(data.toString());
                            break;

                        default:
                            return ResponseEntity.badRequest().body(new DataConversionResponse("Chuyển đổi chưa được hỗ trợ"));
                    }
                    break;

                default:
                    return ResponseEntity.badRequest().body(new DataConversionResponse("Định dạng đầu vào không hỗ trợ"));
            }
            return result;

    }


}
