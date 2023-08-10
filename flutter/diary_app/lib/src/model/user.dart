class User {
  final int id;
  final String adid;
  final String uuid;

  User({
    required this.id,
    required this.adid,
    required this.uuid,
  });

  factory User.fromJson(Map<String, dynamic> json) => User(
    id: json["id"],
    adid: json["adid"],
    uuid: json["uuid"],
  );

  Map<String, dynamic> toJson() => {
    "id": id,
    "adid": adid,
    "uuid": uuid,
  };
}
