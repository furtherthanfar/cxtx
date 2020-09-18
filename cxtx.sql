/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : cxtx

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 18/09/2020 16:45:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `account_id` int(0) NOT NULL AUTO_INCREMENT,
  `account_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account_password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(0) NOT NULL,
  PRIMARY KEY (`account_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `cid` int(0) NOT NULL,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pid` int(0) DEFAULT NULL,
  PRIMARY KEY (`city`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `province` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (10, '七台河市', 10);
INSERT INTO `city` VALUES (7, '万宁市', 24);
INSERT INTO `city` VALUES (2, '三亚市', 24);
INSERT INTO `city` VALUES (4, '三明市', 14);
INSERT INTO `city` VALUES (12, '三门峡市', 17);
INSERT INTO `city` VALUES (1, '上海市', 3);
INSERT INTO `city` VALUES (11, '上饶市', 15);
INSERT INTO `city` VALUES (8, '东方市', 24);
INSERT INTO `city` VALUES (17, '东莞市', 20);
INSERT INTO `city` VALUES (5, '东营市', 16);
INSERT INTO `city` VALUES (5, '中卫市', 30);
INSERT INTO `city` VALUES (18, '中山市', 20);
INSERT INTO `city` VALUES (13, '临夏回族自治州', 21);
INSERT INTO `city` VALUES (10, '临汾市', 6);
INSERT INTO `city` VALUES (13, '临沂市', 16);
INSERT INTO `city` VALUES (8, '临沧市', 25);
INSERT INTO `city` VALUES (12, '临高县', 24);
INSERT INTO `city` VALUES (6, '丹东市', 8);
INSERT INTO `city` VALUES (11, '丽水市', 12);
INSERT INTO `city` VALUES (6, '丽江市', 25);
INSERT INTO `city` VALUES (9, '乌兰察布市', 32);
INSERT INTO `city` VALUES (3, '乌海市', 32);
INSERT INTO `city` VALUES (21, '乌苏市', 31);
INSERT INTO `city` VALUES (1, '乌鲁木齐市', 31);
INSERT INTO `city` VALUES (15, '乐东黎族自治县', 24);
INSERT INTO `city` VALUES (10, '乐山市', 22);
INSERT INTO `city` VALUES (4, '九江市', 15);
INSERT INTO `city` VALUES (16, '云林县', 7);
INSERT INTO `city` VALUES (21, '云浮市', 20);
INSERT INTO `city` VALUES (6, '五家渠市', 31);
INSERT INTO `city` VALUES (3, '五指山市', 24);
INSERT INTO `city` VALUES (15, '亳州市', 13);
INSERT INTO `city` VALUES (13, '仙桃市', 18);
INSERT INTO `city` VALUES (7, '伊 春 市', 10);
INSERT INTO `city` VALUES (18, '伊宁市', 31);
INSERT INTO `city` VALUES (6, '佛山市', 20);
INSERT INTO `city` VALUES (9, '佳木斯市', 10);
INSERT INTO `city` VALUES (17, '保亭黎族苗族自治县', 24);
INSERT INTO `city` VALUES (6, '保定市', 5);
INSERT INTO `city` VALUES (4, '保山市', 25);
INSERT INTO `city` VALUES (15, '信阳市', 17);
INSERT INTO `city` VALUES (5, '儋州市', 24);
INSERT INTO `city` VALUES (2, '克拉玛依市', 31);
INSERT INTO `city` VALUES (14, '六安市', 13);
INSERT INTO `city` VALUES (2, '六盘水市', 23);
INSERT INTO `city` VALUES (1, '兰州市', 21);
INSERT INTO `city` VALUES (11, '兴安盟', 32);
INSERT INTO `city` VALUES (9, '内江市', 22);
INSERT INTO `city` VALUES (21, '凉山彝族自治州', 22);
INSERT INTO `city` VALUES (2, '包头市', 32);
INSERT INTO `city` VALUES (1, '北京市', 1);
INSERT INTO `city` VALUES (5, '北海市', 28);
INSERT INTO `city` VALUES (3, '十堰市', 18);
INSERT INTO `city` VALUES (1, '南京市', 11);
INSERT INTO `city` VALUES (11, '南充市', 22);
INSERT INTO `city` VALUES (1, '南宁市', 28);
INSERT INTO `city` VALUES (7, '南平市', 14);
INSERT INTO `city` VALUES (15, '南投县', 7);
INSERT INTO `city` VALUES (1, '南昌市', 15);
INSERT INTO `city` VALUES (6, '南通市', 11);
INSERT INTO `city` VALUES (13, '南阳市', 17);
INSERT INTO `city` VALUES (17, '博乐市', 31);
INSERT INTO `city` VALUES (2, '厦门市', 14);
INSERT INTO `city` VALUES (4, '双鸭山市', 10);
INSERT INTO `city` VALUES (22, '台东县', 7);
INSERT INTO `city` VALUES (13, '台中县', 7);
INSERT INTO `city` VALUES (4, '台中市', 7);
INSERT INTO `city` VALUES (8, '台北县', 7);
INSERT INTO `city` VALUES (1, '台北市', 7);
INSERT INTO `city` VALUES (18, '台南县', 7);
INSERT INTO `city` VALUES (5, '台南市', 7);
INSERT INTO `city` VALUES (10, '台州市', 12);
INSERT INTO `city` VALUES (1, '合肥市', 13);
INSERT INTO `city` VALUES (8, '吉安市', 15);
INSERT INTO `city` VALUES (2, '吉林市', 9);
INSERT INTO `city` VALUES (7, '吐鲁番市', 31);
INSERT INTO `city` VALUES (11, '吕梁市', 6);
INSERT INTO `city` VALUES (3, '吴忠市', 30);
INSERT INTO `city` VALUES (16, '周口市', 17);
INSERT INTO `city` VALUES (7, '呼伦贝尔市', 32);
INSERT INTO `city` VALUES (1, '呼和浩特市', 32);
INSERT INTO `city` VALUES (11, '和田市', 31);
INSERT INTO `city` VALUES (11, '咸宁市', 18);
INSERT INTO `city` VALUES (4, '咸阳市', 27);
INSERT INTO `city` VALUES (10, '哈密市', 31);
INSERT INTO `city` VALUES (1, '哈尔滨市', 10);
INSERT INTO `city` VALUES (2, '唐山市', 5);
INSERT INTO `city` VALUES (14, '商丘市', 17);
INSERT INTO `city` VALUES (10, '商洛市', 27);
INSERT INTO `city` VALUES (9, '喀什市', 31);
INSERT INTO `city` VALUES (17, '嘉义县', 7);
INSERT INTO `city` VALUES (7, '嘉义市', 7);
INSERT INTO `city` VALUES (4, '嘉兴市', 12);
INSERT INTO `city` VALUES (5, '嘉峪关市', 21);
INSERT INTO `city` VALUES (3, '四平市', 9);
INSERT INTO `city` VALUES (4, '固原市', 30);
INSERT INTO `city` VALUES (5, '图木舒克市', 31);
INSERT INTO `city` VALUES (3, '基隆市', 7);
INSERT INTO `city` VALUES (20, '塔城市', 31);
INSERT INTO `city` VALUES (13, '大兴安岭地区', 10);
INSERT INTO `city` VALUES (2, '大同市', 6);
INSERT INTO `city` VALUES (6, '大庆市', 10);
INSERT INTO `city` VALUES (13, '大理白族自治州', 25);
INSERT INTO `city` VALUES (2, '大连市', 8);
INSERT INTO `city` VALUES (4, '天水市', 21);
INSERT INTO `city` VALUES (1, '天津市', 2);
INSERT INTO `city` VALUES (14, '天门市', 18);
INSERT INTO `city` VALUES (1, '太原市', 6);
INSERT INTO `city` VALUES (19, '奎屯市', 31);
INSERT INTO `city` VALUES (10, '威海市', 16);
INSERT INTO `city` VALUES (13, '娄底市', 19);
INSERT INTO `city` VALUES (9, '孝感市', 18);
INSERT INTO `city` VALUES (9, '宁德市', 14);
INSERT INTO `city` VALUES (2, '宁波市', 12);
INSERT INTO `city` VALUES (8, '安庆市', 13);
INSERT INTO `city` VALUES (9, '安康市', 27);
INSERT INTO `city` VALUES (5, '安阳市', 17);
INSERT INTO `city` VALUES (4, '安顺市', 23);
INSERT INTO `city` VALUES (10, '定安县', 24);
INSERT INTO `city` VALUES (11, '定西市', 21);
INSERT INTO `city` VALUES (9, '宜兰县', 7);
INSERT INTO `city` VALUES (13, '宜宾市', 22);
INSERT INTO `city` VALUES (5, '宜昌市', 18);
INSERT INTO `city` VALUES (9, '宜春市', 15);
INSERT INTO `city` VALUES (3, '宝鸡市', 27);
INSERT INTO `city` VALUES (17, '宣城市', 13);
INSERT INTO `city` VALUES (12, '宿州市', 13);
INSERT INTO `city` VALUES (13, '宿迁市', 11);
INSERT INTO `city` VALUES (20, '屏东县', 7);
INSERT INTO `city` VALUES (11, '屯昌县', 24);
INSERT INTO `city` VALUES (4, '山南地区', 29);
INSERT INTO `city` VALUES (6, '岳阳市', 19);
INSERT INTO `city` VALUES (14, '崇左市', 28);
INSERT INTO `city` VALUES (13, '巢湖市', 13);
INSERT INTO `city` VALUES (17, '巴中市', 22);
INSERT INTO `city` VALUES (8, '巴彦淖尔市', 32);
INSERT INTO `city` VALUES (4, '常州市', 11);
INSERT INTO `city` VALUES (7, '常德市', 19);
INSERT INTO `city` VALUES (8, '平凉市', 21);
INSERT INTO `city` VALUES (4, '平顶山市', 17);
INSERT INTO `city` VALUES (7, '广元市', 22);
INSERT INTO `city` VALUES (14, '广安市', 22);
INSERT INTO `city` VALUES (1, '广州市', 20);
INSERT INTO `city` VALUES (10, '庆阳市', 21);
INSERT INTO `city` VALUES (13, '库尔勒市', 31);
INSERT INTO `city` VALUES (10, '廊坊市', 5);
INSERT INTO `city` VALUES (6, '延安市', 27);
INSERT INTO `city` VALUES (9, '延边朝鲜族自治州', 9);
INSERT INTO `city` VALUES (2, '开封市', 17);
INSERT INTO `city` VALUES (7, '张家口市', 5);
INSERT INTO `city` VALUES (8, '张家界市', 19);
INSERT INTO `city` VALUES (7, '张掖市', 21);
INSERT INTO `city` VALUES (14, '彰化县', 7);
INSERT INTO `city` VALUES (3, '徐州市', 11);
INSERT INTO `city` VALUES (14, '德宏傣族景颇族自治州', 25);
INSERT INTO `city` VALUES (14, '德州市', 16);
INSERT INTO `city` VALUES (5, '德阳市', 22);
INSERT INTO `city` VALUES (9, '忻州市', 6);
INSERT INTO `city` VALUES (12, '怀化市', 19);
INSERT INTO `city` VALUES (15, '怒江傈傈族自治州', 25);
INSERT INTO `city` VALUES (7, '思茅市', 25);
INSERT INTO `city` VALUES (17, '恩施土家族苗族自治州', 18);
INSERT INTO `city` VALUES (11, '惠州市', 20);
INSERT INTO `city` VALUES (1, '成都市', 22);
INSERT INTO `city` VALUES (10, '扬州市', 11);
INSERT INTO `city` VALUES (8, '承德市', 5);
INSERT INTO `city` VALUES (10, '抚州市', 15);
INSERT INTO `city` VALUES (4, '抚顺市', 8);
INSERT INTO `city` VALUES (1, '拉萨市', 29);
INSERT INTO `city` VALUES (20, '揭阳市', 20);
INSERT INTO `city` VALUES (3, '攀枝花市', 22);
INSERT INTO `city` VALUES (9, '文山壮族苗族自治州', 25);
INSERT INTO `city` VALUES (6, '文昌市', 24);
INSERT INTO `city` VALUES (7, '新乡市', 17);
INSERT INTO `city` VALUES (5, '新余市', 15);
INSERT INTO `city` VALUES (11, '新竹县', 7);
INSERT INTO `city` VALUES (6, '新竹市', 7);
INSERT INTO `city` VALUES (2, '无锡市', 11);
INSERT INTO `city` VALUES (5, '日喀则地区', 29);
INSERT INTO `city` VALUES (11, '日照市', 16);
INSERT INTO `city` VALUES (14, '昌吉市　', 31);
INSERT INTO `city` VALUES (14, '昌江黎族自治县', 24);
INSERT INTO `city` VALUES (3, '昌都地区', 29);
INSERT INTO `city` VALUES (5, '昭通市', 25);
INSERT INTO `city` VALUES (7, '晋中市', 6);
INSERT INTO `city` VALUES (5, '晋城市', 6);
INSERT INTO `city` VALUES (2, '景德镇市', 15);
INSERT INTO `city` VALUES (2, '曲靖市', 25);
INSERT INTO `city` VALUES (6, '朔州市', 6);
INSERT INTO `city` VALUES (13, '朝阳市', 8);
INSERT INTO `city` VALUES (5, '本溪市', 8);
INSERT INTO `city` VALUES (13, '来宾市', 28);
INSERT INTO `city` VALUES (1, '杭州市', 12);
INSERT INTO `city` VALUES (7, '松原市', 9);
INSERT INTO `city` VALUES (7, '林芝地区', 29);
INSERT INTO `city` VALUES (6, '果洛藏族自治州', 26);
INSERT INTO `city` VALUES (4, '枣庄市', 16);
INSERT INTO `city` VALUES (2, '柳州市', 28);
INSERT INTO `city` VALUES (2, '株洲市', 19);
INSERT INTO `city` VALUES (3, '桂林市', 28);
INSERT INTO `city` VALUES (10, '桃园县', 7);
INSERT INTO `city` VALUES (12, '梅州市', 20);
INSERT INTO `city` VALUES (4, '梧州市', 28);
INSERT INTO `city` VALUES (12, '楚雄彝族自治州', 25);
INSERT INTO `city` VALUES (8, '榆林市', 27);
INSERT INTO `city` VALUES (6, '武威市', 21);
INSERT INTO `city` VALUES (1, '武汉市', 18);
INSERT INTO `city` VALUES (6, '毕节地区', 23);
INSERT INTO `city` VALUES (11, '永州市', 19);
INSERT INTO `city` VALUES (7, '汉中市', 27);
INSERT INTO `city` VALUES (4, '汕头市', 20);
INSERT INTO `city` VALUES (13, '汕尾市', 20);
INSERT INTO `city` VALUES (7, '江门市', 20);
INSERT INTO `city` VALUES (16, '池州市', 13);
INSERT INTO `city` VALUES (1, '沈阳市', 8);
INSERT INTO `city` VALUES (9, '沧州市', 5);
INSERT INTO `city` VALUES (12, '河池市', 28);
INSERT INTO `city` VALUES (14, '河源市', 20);
INSERT INTO `city` VALUES (5, '泉州市', 14);
INSERT INTO `city` VALUES (9, '泰安市', 16);
INSERT INTO `city` VALUES (12, '泰州市', 11);
INSERT INTO `city` VALUES (4, '泸州市', 22);
INSERT INTO `city` VALUES (3, '洛阳市', 17);
INSERT INTO `city` VALUES (1, '济南市', 16);
INSERT INTO `city` VALUES (8, '济宁市', 16);
INSERT INTO `city` VALUES (18, '济源市', 17);
INSERT INTO `city` VALUES (2, '海东地区', 26);
INSERT INTO `city` VALUES (3, '海北藏族自治州', 26);
INSERT INTO `city` VALUES (5, '海南藏族自治州', 26);
INSERT INTO `city` VALUES (1, '海口市', 24);
INSERT INTO `city` VALUES (8, '海西蒙古族藏族自治州', 26);
INSERT INTO `city` VALUES (3, '淄博市', 16);
INSERT INTO `city` VALUES (6, '淮北市', 13);
INSERT INTO `city` VALUES (4, '淮南市', 13);
INSERT INTO `city` VALUES (8, '淮安市', 11);
INSERT INTO `city` VALUES (2, '深圳市', 20);
INSERT INTO `city` VALUES (16, '清远市', 20);
INSERT INTO `city` VALUES (3, '温州市', 12);
INSERT INTO `city` VALUES (5, '渭南市', 27);
INSERT INTO `city` VALUES (5, '湖州市', 12);
INSERT INTO `city` VALUES (3, '湘潭市', 19);
INSERT INTO `city` VALUES (14, '湘西土家族苗族自治州', 19);
INSERT INTO `city` VALUES (8, '湛江市', 20);
INSERT INTO `city` VALUES (10, '滁州市', 13);
INSERT INTO `city` VALUES (16, '滨州市', 16);
INSERT INTO `city` VALUES (11, '漯河市', 17);
INSERT INTO `city` VALUES (6, '漳州市', 14);
INSERT INTO `city` VALUES (7, '潍坊市', 16);
INSERT INTO `city` VALUES (15, '潜江市', 18);
INSERT INTO `city` VALUES (19, '潮州市', 20);
INSERT INTO `city` VALUES (9, '澄迈县', 24);
INSERT INTO `city` VALUES (21, '澎湖县', 7);
INSERT INTO `city` VALUES (1, '澳门特别行政区', 33);
INSERT INTO `city` VALUES (9, '濮阳市', 17);
INSERT INTO `city` VALUES (6, '烟台市', 16);
INSERT INTO `city` VALUES (8, '焦作市', 17);
INSERT INTO `city` VALUES (8, '牡丹江市', 10);
INSERT INTO `city` VALUES (9, '玉林市', 28);
INSERT INTO `city` VALUES (7, '玉树藏族自治州', 26);
INSERT INTO `city` VALUES (3, '玉溪市', 25);
INSERT INTO `city` VALUES (3, '珠海市', 20);
INSERT INTO `city` VALUES (18, '琼中黎族苗族自治县', 24);
INSERT INTO `city` VALUES (4, '琼海市', 24);
INSERT INTO `city` VALUES (14, '甘南藏族自治州', 21);
INSERT INTO `city` VALUES (20, '甘孜藏族自治州', 22);
INSERT INTO `city` VALUES (8, '白城市', 9);
INSERT INTO `city` VALUES (6, '白山市', 9);
INSERT INTO `city` VALUES (13, '白沙黎族自治县', 24);
INSERT INTO `city` VALUES (3, '白银市', 21);
INSERT INTO `city` VALUES (10, '百色市', 28);
INSERT INTO `city` VALUES (9, '益阳市', 19);
INSERT INTO `city` VALUES (9, '盐城市', 11);
INSERT INTO `city` VALUES (11, '盘锦市', 8);
INSERT INTO `city` VALUES (12, '眉山市', 22);
INSERT INTO `city` VALUES (2, '石嘴山市', 30);
INSERT INTO `city` VALUES (1, '石家庄市', 5);
INSERT INTO `city` VALUES (3, '石河子市　', 31);
INSERT INTO `city` VALUES (16, '神农架林区', 18);
INSERT INTO `city` VALUES (1, '福州市', 14);
INSERT INTO `city` VALUES (3, '秦皇岛市', 5);
INSERT INTO `city` VALUES (16, '米泉市', 31);
INSERT INTO `city` VALUES (10, '红河哈尼族彝族自治州', 25);
INSERT INTO `city` VALUES (6, '绍兴市', 12);
INSERT INTO `city` VALUES (12, '绥 化 市', 10);
INSERT INTO `city` VALUES (6, '绵阳市', 22);
INSERT INTO `city` VALUES (15, '聊城市', 16);
INSERT INTO `city` VALUES (10, '肇庆市', 20);
INSERT INTO `city` VALUES (2, '自贡市', 22);
INSERT INTO `city` VALUES (9, '舟山市', 12);
INSERT INTO `city` VALUES (2, '芜湖市', 13);
INSERT INTO `city` VALUES (23, '花莲县', 7);
INSERT INTO `city` VALUES (5, '苏州市', 11);
INSERT INTO `city` VALUES (12, '苗栗县', 7);
INSERT INTO `city` VALUES (9, '茂名市', 20);
INSERT INTO `city` VALUES (4, '荆州市', 18);
INSERT INTO `city` VALUES (8, '荆门市', 18);
INSERT INTO `city` VALUES (3, '莆田市', 14);
INSERT INTO `city` VALUES (12, '莱芜市', 16);
INSERT INTO `city` VALUES (17, '菏泽市', 16);
INSERT INTO `city` VALUES (3, '萍乡市', 15);
INSERT INTO `city` VALUES (8, '营口市', 8);
INSERT INTO `city` VALUES (14, '葫芦岛市', 8);
INSERT INTO `city` VALUES (3, '蚌埠市', 13);
INSERT INTO `city` VALUES (11, '衡水市', 5);
INSERT INTO `city` VALUES (4, '衡阳市', 19);
INSERT INTO `city` VALUES (8, '衢州市', 12);
INSERT INTO `city` VALUES (6, '襄樊市', 18);
INSERT INTO `city` VALUES (11, '西双版纳傣族自治州', 25);
INSERT INTO `city` VALUES (1, '西宁市', 26);
INSERT INTO `city` VALUES (1, '西安市', 27);
INSERT INTO `city` VALUES (10, '许昌市', 17);
INSERT INTO `city` VALUES (8, '贵港市', 28);
INSERT INTO `city` VALUES (1, '贵阳市', 23);
INSERT INTO `city` VALUES (11, '贺州市', 28);
INSERT INTO `city` VALUES (18, '资阳市', 22);
INSERT INTO `city` VALUES (7, '赣州市', 15);
INSERT INTO `city` VALUES (4, '赤峰市', 32);
INSERT INTO `city` VALUES (4, '辽源市', 9);
INSERT INTO `city` VALUES (10, '辽阳市', 8);
INSERT INTO `city` VALUES (15, '达州市', 22);
INSERT INTO `city` VALUES (8, '运城市', 6);
INSERT INTO `city` VALUES (7, '连云港市', 11);
INSERT INTO `city` VALUES (16, '迪庆藏族自治州', 25);
INSERT INTO `city` VALUES (5, '通化市', 9);
INSERT INTO `city` VALUES (5, '通辽市', 32);
INSERT INTO `city` VALUES (8, '遂宁市', 22);
INSERT INTO `city` VALUES (3, '遵义市', 23);
INSERT INTO `city` VALUES (5, '邢台市', 5);
INSERT INTO `city` VALUES (2, '那曲地区', 29);
INSERT INTO `city` VALUES (4, '邯郸市', 5);
INSERT INTO `city` VALUES (5, '邵阳市', 19);
INSERT INTO `city` VALUES (1, '郑州市', 17);
INSERT INTO `city` VALUES (10, '郴州市', 19);
INSERT INTO `city` VALUES (6, '鄂尔多斯市', 32);
INSERT INTO `city` VALUES (7, '鄂州市', 18);
INSERT INTO `city` VALUES (9, '酒泉市', 21);
INSERT INTO `city` VALUES (1, '重庆市', 4);
INSERT INTO `city` VALUES (7, '金华市', 12);
INSERT INTO `city` VALUES (2, '金昌市', 21);
INSERT INTO `city` VALUES (7, '钦州市', 28);
INSERT INTO `city` VALUES (12, '铁岭市', 8);
INSERT INTO `city` VALUES (5, '铜仁地区', 23);
INSERT INTO `city` VALUES (2, '铜川市', 27);
INSERT INTO `city` VALUES (7, '铜陵市', 13);
INSERT INTO `city` VALUES (1, '银川市', 30);
INSERT INTO `city` VALUES (10, '锡林郭勒盟', 32);
INSERT INTO `city` VALUES (7, '锦州市', 8);
INSERT INTO `city` VALUES (11, '镇江市', 11);
INSERT INTO `city` VALUES (1, '长春市', 9);
INSERT INTO `city` VALUES (1, '长沙市', 19);
INSERT INTO `city` VALUES (4, '长治市', 6);
INSERT INTO `city` VALUES (15, '阜康市', 31);
INSERT INTO `city` VALUES (9, '阜新市', 8);
INSERT INTO `city` VALUES (11, '阜阳市', 13);
INSERT INTO `city` VALUES (6, '防城港市', 28);
INSERT INTO `city` VALUES (15, '阳江市', 20);
INSERT INTO `city` VALUES (3, '阳泉市', 6);
INSERT INTO `city` VALUES (8, '阿克苏市', 31);
INSERT INTO `city` VALUES (22, '阿勒泰市', 31);
INSERT INTO `city` VALUES (12, '阿图什市', 31);
INSERT INTO `city` VALUES (19, '阿坝藏族羌族自治州', 22);
INSERT INTO `city` VALUES (12, '阿拉善盟', 32);
INSERT INTO `city` VALUES (4, '阿拉尔市', 31);
INSERT INTO `city` VALUES (6, '阿里地区', 29);
INSERT INTO `city` VALUES (12, '陇南市', 21);
INSERT INTO `city` VALUES (16, '陵水黎族自治县', 24);
INSERT INTO `city` VALUES (12, '随州市', 18);
INSERT INTO `city` VALUES (16, '雅安市', 22);
INSERT INTO `city` VALUES (2, '青岛市', 16);
INSERT INTO `city` VALUES (3, '鞍山市', 8);
INSERT INTO `city` VALUES (5, '韶关市', 20);
INSERT INTO `city` VALUES (1, '香港特别行政区', 34);
INSERT INTO `city` VALUES (5, '马鞍山市', 13);
INSERT INTO `city` VALUES (17, '驻马店市', 17);
INSERT INTO `city` VALUES (19, '高雄县', 7);
INSERT INTO `city` VALUES (2, '高雄市', 7);
INSERT INTO `city` VALUES (5, '鸡西市', 10);
INSERT INTO `city` VALUES (6, '鹤壁市', 17);
INSERT INTO `city` VALUES (3, '鹤岗市', 10);
INSERT INTO `city` VALUES (6, '鹰潭市', 15);
INSERT INTO `city` VALUES (10, '黄冈市', 18);
INSERT INTO `city` VALUES (4, '黄南藏族自治州', 26);
INSERT INTO `city` VALUES (9, '黄山市', 13);
INSERT INTO `city` VALUES (2, '黄石市', 18);
INSERT INTO `city` VALUES (11, '黑河市', 10);
INSERT INTO `city` VALUES (8, '黔东南苗族侗族自治州', 23);
INSERT INTO `city` VALUES (9, '黔南布依族苗族自治州', 23);
INSERT INTO `city` VALUES (7, '黔西南布依族苗族自治州', 23);
INSERT INTO `city` VALUES (2, '齐齐哈尔市', 10);
INSERT INTO `city` VALUES (8, '龙岩市', 14);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '订单ID号',
  `order_encoding` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
  `route_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '购买的路线名称',
  `account_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单用户名',
  `order_total_price` float(10, 2) NOT NULL COMMENT '原价',
  `order_reduce_price` float(10, 2) NOT NULL COMMENT '优惠减免',
  `order_actual_price` float(10, 2) NOT NULL COMMENT '实际价格',
  `order_creat_time` date NOT NULL COMMENT '订单创建日期',
  `order_pay_time` date NOT NULL COMMENT '订单支付日期',
  `order_note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单备注',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province`  (
  `pid` int(0) NOT NULL,
  `province` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES (1, '北京市');
INSERT INTO `province` VALUES (2, '天津市');
INSERT INTO `province` VALUES (3, '上海市');
INSERT INTO `province` VALUES (4, '重庆市');
INSERT INTO `province` VALUES (5, '河北省');
INSERT INTO `province` VALUES (6, '山西省');
INSERT INTO `province` VALUES (7, '台湾省');
INSERT INTO `province` VALUES (8, '辽宁省');
INSERT INTO `province` VALUES (9, '吉林省');
INSERT INTO `province` VALUES (10, '黑龙江省');
INSERT INTO `province` VALUES (11, '江苏省');
INSERT INTO `province` VALUES (12, '浙江省');
INSERT INTO `province` VALUES (13, '安徽省');
INSERT INTO `province` VALUES (14, '福建省');
INSERT INTO `province` VALUES (15, '江西省');
INSERT INTO `province` VALUES (16, '山东省');
INSERT INTO `province` VALUES (17, '河南省');
INSERT INTO `province` VALUES (18, '湖北省');
INSERT INTO `province` VALUES (19, '湖南省');
INSERT INTO `province` VALUES (20, '广东省');
INSERT INTO `province` VALUES (21, '甘肃省');
INSERT INTO `province` VALUES (22, '四川省');
INSERT INTO `province` VALUES (23, '贵州省');
INSERT INTO `province` VALUES (24, '海南省');
INSERT INTO `province` VALUES (25, '云南省');
INSERT INTO `province` VALUES (26, '青海省');
INSERT INTO `province` VALUES (27, '陕西省');
INSERT INTO `province` VALUES (28, '广西壮族自治区');
INSERT INTO `province` VALUES (29, '西藏自治区');
INSERT INTO `province` VALUES (30, '宁夏回族自治区');
INSERT INTO `province` VALUES (31, '新疆维吾尔自治区');
INSERT INTO `province` VALUES (32, '内蒙古自治区');
INSERT INTO `province` VALUES (33, '澳门特别行政区');
INSERT INTO `province` VALUES (34, '香港特别行政区');

-- ----------------------------
-- Table structure for route
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route`  (
  `route_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '路线ID',
  `route_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '路线名称',
  `route_description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '路线描述',
  PRIMARY KEY (`route_id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for route_site
-- ----------------------------
DROP TABLE IF EXISTS `route_site`;
CREATE TABLE `route_site`  (
  `route_id` int(0) NOT NULL COMMENT '路线ID',
  `site_id` int(0) NOT NULL COMMENT '景点ID',
  `rank_num` int(0) DEFAULT NULL,
  PRIMARY KEY (`route_id`, `site_id`) USING BTREE,
  INDEX `site_id`(`site_id`) USING BTREE,
  CONSTRAINT `route_site_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `route_site_ibfk_2` FOREIGN KEY (`site_id`) REFERENCES `site` (`site_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for site
-- ----------------------------
DROP TABLE IF EXISTS `site`;
CREATE TABLE `site`  (
  `site_id` int(0) NOT NULL AUTO_INCREMENT,
  `site_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `site_description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `site_price` double(10, 2) NOT NULL,
  `site_discount` float(3, 2) DEFAULT NULL,
  `site_dc_reason` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `city_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`site_id`) USING BTREE,
  INDEX `city_name`(`city_name`) USING BTREE,
  CONSTRAINT `site_ibfk_1` FOREIGN KEY (`city_name`) REFERENCES `city` (`city`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for spicture
-- ----------------------------
DROP TABLE IF EXISTS `spicture`;
CREATE TABLE `spicture`  (
  `sp_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '景点图片ID',
  `sp_path` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '景点图片路径',
  `site_id` int(0) NOT NULL COMMENT '景点ID',
  PRIMARY KEY (`sp_id`) USING BTREE,
  INDEX `site_id`(`site_id`) USING BTREE,
  CONSTRAINT `spicture_ibfk_1` FOREIGN KEY (`site_id`) REFERENCES `site` (`site_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for strategy
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy`  (
  `strategy_id` int(0) NOT NULL AUTO_INCREMENT,
  `strategy_time` datetime(0) NOT NULL,
  `strategy_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(0) NOT NULL,
  PRIMARY KEY (`strategy_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `strategy_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `user_nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `user_gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `user_birth` date DEFAULT NULL COMMENT '生日',
  `user_real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实姓名',
  `user_phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
  `user_email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Email',
  `user_career` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职业',
  `user_description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个性签名',
  `city_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '城市名',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `city_name`(`city_name`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`city_name`) REFERENCES `city` (`city`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for wallet
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet`  (
  `wallet_id` int(0) NOT NULL AUTO_INCREMENT,
  `wallet_balance` double(10, 2) DEFAULT NULL,
  `wallet_score` int(0) DEFAULT NULL,
  `user_id` int(0) DEFAULT NULL,
  PRIMARY KEY (`wallet_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `wallet_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



SET FOREIGN_KEY_CHECKS = 1;
