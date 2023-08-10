import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:flutter/material.dart';

class UserAPI {
  static const httpUri = 'user ip: port';

  requestRegisterUserToSpring(adid, uuid) async {
    var data = {
      'adid': adid,
      'uuid': uuid
    };
    var body = json.encode(data);
    try {
      var requestRegisterUserResponse = await http.post(
        Uri.http(httpUri, 'daily-diary/user/register'),
        headers: {"Content-Type": "application/json"},
        body: body,
      );

      debugPrint(requestRegisterUserResponse.statusCode.toString());
      if (requestRegisterUserResponse.statusCode == 200) {
        debugPrint("사용자 등록 결과 : " +
            utf8.decode(requestRegisterUserResponse.bodyBytes).toString());
      }
    } catch (e) {
      debugPrint("오류 발생 " + e.toString());
    }
  }
}
