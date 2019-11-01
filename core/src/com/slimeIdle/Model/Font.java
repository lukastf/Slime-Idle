package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Font {

    /** Default Glyphs (English, German, Russian, Vietnamese, and more...). */
    public String DEFAULT_GLYPHS = "∅ ★✎✏  ✉✪✤☠ ☚☛◆✖♠♣♥♦◄ ►➨➲◉○☐☑☒⌦●•‣◦♪♫✓✔✕✖✗✘♂♀℠™©®℅½¼∞₀₁₂₃₄₅₆₇₈₉°⁰¹²³⁴⁵⁶⁷⁸⁹ᴬᴮᴰᴱᴳᴴᴵᴶᴷᴸᴹᴺᴼᴾᴿᵀᵁᵂᵃᵇᶜᵈᵉᶠᵍʰⁱʲᵏˡᵐⁿᵒᵖʳˢᵗᵘᵛʷˣʸᶻⁱⁿᵅᵝᵞᵟαβγδ⁽⁾⁺⁻+±-×÷·∙∕=≥≤≠≈√∑%‰‱ ␣ ↯ ↩  ↺ ↻!¡?¿\"`´'^«».,;:()[]{}<>|¦/\\#_&~* \u2019¢£€$₩฿₪₱¤¥§¨­¯µ¶@·¸… \u00A0 \u202F ␣ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿαΑβΒγΓδΔεΕζΖηΗθΘιΙκΚλΛμΜνΝξΞοΟπΠρΡσςΣτΤυΥφΦχΧψΨωΩ ĀĐĘĶŃÓŚŰāđęķńóśűĂĎĚĹŅŒŠŲăďěĺņœšųĄĒĻŇŕŢŸąēĢļňŖţŹĆĕģĽŌŗźćĖĪľōŘťŻČėīŐřżčĮŁőŞŽįłşž А Б В Г ДЕЁЖЗИЙКЛМНОПРСТУФХЦЧ ШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя A/a, Ă/ă, Â/â, E/e, Ê/ê, I/i, O/o, Ô/ô, Ơ/ơ, U/u, Ư/ư, Y/yÀ/à, Ằ/ằ, Ầ/ầ, È/è, Ề/ề, Ì/ì, Ò/ò, Ồ/ồ, Ờ/ờ, Ù/ù, Ừ/ừ, Ỳ/ỳẢ/ả, Ẳ/ẳ, Ẩ/ẩ, Ẻ/ẻ, Ể/ể, Ỉ/ỉ, Ỏ/ỏ, Ổ/ổ, Ở/ở, Ủ/ủ, Ử/ử, Ỷ/ỷÃ/ã, Ẵ/ẵ, Ẫ/ẫ, Ẽ/ẽ, Ễ/ễ, Ĩ/ĩ, Õ/õ, Ỗ/ỗ, Ỡ/ỡ, Ũ/ũ, Ữ/ữ, Ỹ/ỹÁ/á, Ắ/ắ, Ấ/ấ, É/é, Ế/ế, Í/í, Ó/ó, Ố/ố, Ớ/ớ, Ú/ú, Ứ/ứ, Ý/ýẠ/ạ, Ặ/ặ, Ậ/ậ, Ẹ/ẹ, Ệ/ệ, Ị/ị, Ọ/ọ, Ộ/ộ, Ợ/ợ, Ụ/ụ, Ự/ự, Ỵ/ỵɣBbCcDdĐđGgHhKkLlMmNnPpQqRrSsTtVvXx ğışİŞĞ’ōūöçü";
    /** Glyph List for Japanese. */
    public String GLYPHS_JA = " 〒 ＋ ー ・＊ Ｂ Ｇ Ｍ 哨 Ａ Ｉ 狙 捷 ― ～ … 凱 崖 ＆ 灼 諜​ ＃ ％ 蜂 叛 讐 誰 闇 殲 鎧 桁 嵐 焉 槍 須 捗 賭 冶饒饗傭埠埠蹴厩？、，· （）！々●：／。ー１２３４５６７８９０「」ぁ あ   ぃ   い   ぅ   う   ぇ   え   ぉ   お   か   が   き   ぎ   く    ぐ   け   げ   こ   ご   さ   ざ   し   じ   す   ず   せ   ぜ   そ   ぞ   た    だ   ち   ぢ   っ   つ   づ   て   で   と   ど   な   に   ぬ   ね   の   は    ば   ぱ   ひ   び   ぴ   ふ   ぶ   ぷ   へ   べ   ぺ   ほ   ぼ   ぽ   ま   み    む   め   も   ゃ   や   ゅ   ゆ   ょ   よ   ら   り   る   れ   ろ   ゎ   わ    ゐ   ゑ   を   ん   ゔ   ゕ   ゖ       ゙   ゚   ゛   ゜   ゝ   ゞ   ゟ    ゠   ァ   ア   ィ   イ   ゥ   ウ   ェ   エ   ォ   オ   カ   ガ   キ   ギ   ク    グ   ケ   ゲ   コ   ゴ   サ   ザ   シ   ジ   ス   ズ   セ   ゼ   ソ   ゾ   タ    ダ   チ   ヂ   ッ   ツ   ヅ   テ   デ   ト   ド   ナ   ニ   ヌ   ネ   ノ   ハ    バ   パ   ヒ   ビ   ピ   フ   ブ   プ   ヘ   ベ   ペ   ホ   ボ   ポ   マ   ミ    ム   メ   モ   ャ   ヤ   ュ   ユ   ョ   ヨ   ラ   リ   ル   レ   ロ   ヮ   ワ    ヰ   ヱ   ヲ   ン   ヴ   ヵ   ヶ   ヷ   ヸ   ヹ   ヺ   ・   ー   ヽ   ヾ   ヿ・亜　哀　愛　悪　握　圧　扱　安　暗　案　以　位　依　偉　囲　委　威　尉　意　慰　易　為　異　移　維　緯　胃　衣　違　遺　医　井　域　育　一　壱　逸　稲　芋　印　員　因　姻　引　飲　院　陰　隠　韻　右　宇　羽　雨　渦　浦　運　雲　営　影　映　栄　永　泳　英　衛　詠　鋭　液　疫　益　駅　悦　謁　越　閲　円　園　宴　延　援　沿　演　炎　煙　猿　縁　遠　鉛　塩　汚　凹　央　奥　往　応　押　横　欧　殴　王　翁　黄　沖　億　屋　憶　乙　卸　恩　温　穏　音　下　化　仮　何　価　佳　加　可　夏　嫁　家　寡　科　暇　果　架　歌　河　火　禍　稼　箇　花　荷　華　菓　課　貨　過　蚊　我　画　芽　賀　雅　餓　介　会　解　回　塊　壊　快　怪　悔　懐　戒　拐　改　械　海　灰　界　皆　絵　開　階　貝　劾　外　害　慨　概　涯　街　該　垣　嚇　各　拡　格　核　殻　獲　確　穫　覚　角　較　郭　閣　隔　革　学　岳　楽　額　掛　潟　割　喝　括　活　渇　滑　褐　轄　且　株　刈　乾　冠　寒　刊　勘　勧　巻　喚　堪　完　官　寛　干　幹　患　感　慣　憾　換　敢　棺　款　歓　汗　漢　環　甘　監　看　管　簡　緩　缶　肝　艦　観　貫　還　鑑　間　閑　関　陥　館　丸　含　岸　眼　岩　頑　顔　願　企　危　喜　器　基　奇　寄　岐　希　幾　忌　揮　机　旗　既　期　棋　棄　機　帰　気　汽　祈　季　紀　規　記　貴　起　軌　輝　飢　騎　鬼　偽　儀　宜　戯　技　擬　欺　犠　疑　義　議　菊　吉　喫　詰　却　客　脚　虐　逆　丘　久　休　及　吸　宮　弓　急　救　朽　求　泣　球　究　窮　級　糾　給　旧　牛　去　居　巨　拒　拠　挙　虚　許　距　漁　魚　享　京　供　競　共　凶　協　叫　境　峡　強　恐　恭　挟　教　橋　況　狂　狭　矯　胸　脅　興　郷　鏡　響　驚　仰　凝　暁　業　局　曲　極　玉　勤　均　斤　琴　禁　筋　緊　菌　襟　謹　近　金　吟　銀　九　句　区　苦　駆　具　愚　虞　空　偶　遇　隅　屈　掘　靴　繰　桑　勲　君　薫　訓　群　軍　郡　係　傾　刑　兄　啓　型　契　形　径　恵　慶　憩　掲　携　敬　景　渓　系　経　継　茎　蛍　計　警　軽　鶏　芸　迎　鯨　劇　撃　激　傑　欠　決　潔　穴　結　血　月　件　倹　健　兼　券　剣　圏　堅　嫌　建　憲　懸　検　権　犬　献　研　絹　県　肩　見　謙　賢　軒　遣　険　顕　験　元　原　厳　幻　弦　減　源　玄　現　言　限　個　古　呼　固　孤　己　庫　弧　戸　故　枯　湖　誇　雇　顧　鼓　五　互　午　呉　娯　後　御　悟　碁　語　誤　護　交　侯　候　光　公　功　効　厚　口　向　后　坑　好　孔　孝　工　巧　幸　広　康　恒　慌　抗　拘　控　攻　更　校　構　江　洪　港　溝　甲　皇　硬　稿　紅　絞　綱　耕　考　肯　航　荒　行　衡　講　貢　購　郊　酵　鉱　鋼　降　項　香　高　剛　号　合　拷　豪　克　刻　告　国　穀　酷　黒　獄　腰　骨　込　今　困　墾　婚　恨　懇　昆　根　混　紺　魂　佐　唆　左　差　査　砂　詐　鎖　座　債　催　再　最　妻　宰　彩　才　採　栽　歳　済　災　砕　祭　斎　細　菜　裁　載　際　剤　在　材　罪　財　坂　咲　崎　作　削　搾　昨　策　索　錯　桜　冊　刷　察　撮　擦　札　殺　雑　皿　三　傘　参　山　惨　散　桟　産　算　蚕　賛　酸　暫　残　仕　伺　使　刺　司　史　嗣　四　士　始　姉　姿　子　市　師　志　思　指　支　施　旨　枝　止　死　氏　祉　私　糸　紙　紫　肢　脂　至　視　詞　詩　試　誌　諮　資　賜　雌　飼　歯　事　似　侍　児　字　寺　慈　持　時　次　滋　治　璽　磁　示　耳　自　辞　式　識　軸　七　執　失　室　湿　漆　疾　質　実　芝　舎　写　射　捨　赦　斜　煮　社　者　謝　車　遮　蛇　邪　借　勺　尺　爵　酌　釈　若　寂　弱　主　取　守　手　朱　殊　狩　珠　種　趣　酒　首　儒　受　寿　授　樹　需　囚　収　周　宗　就　州　修　愁　拾　秀　秋　終　習　臭　舟　衆　襲　週　酬　集　醜　住　充　十　従　柔　汁　渋　獣　縦　重　銃　叔　宿　淑　祝　縮　粛　塾　熟　出　術　述　俊　春　瞬　准　循　旬　殉　準　潤　盾　純　巡　遵　順　処　初　所　暑　庶　緒　署　書　諸　助　叙　女　序　徐　除　傷　償　勝　匠　升　召　商　唱　奨　宵　将　小　少　尚　床　彰　承　抄　招　掌　昇　昭　晶　松　沼　消　渉　焼　焦　照　症　省　硝　礁　祥　称　章　笑　粧　紹　肖　衝　訟　証　詔　詳　象　賞　鐘　障　上　丈　乗　冗　剰　城　場　壌　嬢　常　情　条　浄　状　畳　蒸　譲　醸　錠　嘱　飾　植　殖　織　職　色　触　食　辱　伸　信　侵　唇　娠　寝　審　心　慎　振　新　森　浸　深　申　真　神　紳　臣　薪　親　診　身　辛　進　針　震　人　仁　刃　尋　甚　尽　迅　陣　酢　図　吹　垂　帥　推　水　炊　睡　粋　衰　遂　酔　錘　随　髄　崇　数　枢　据　杉　澄　寸　世　瀬　畝　是　制　勢　姓　征　性　成　政　整　星　晴　正　清　牲　生　盛　精　聖　声　製　西　誠　誓　請　逝　青　静　斉　税　隻　席　惜　斥　昔　析　石　積　籍　績　責　赤　跡　切　拙　接　摂　折　設　窃　節　説　雪　絶　舌　仙　先　千　占　宣　専　川　戦　扇　栓　泉　浅　洗　染　潜　旋　線　繊　船　薦　践　選　遷　銭　銑　鮮　前　善　漸　然　全　禅　繕　塑　措　疎　礎　祖　租　粗　素　組　訴　阻　僧　創　双　倉　喪　壮　奏　層　想　捜　掃　挿　操　早　曹　巣　槽　燥　争　相　窓　総　草　荘　葬　藻　装　走　送　遭　霜　騒　像　増　憎　臓　蔵　贈　造　促　側　則　即　息　束　測　足　速　俗　属　賊　族　続　卒　存　孫　尊　損　村　他　多　太　堕　妥　惰　打　駄　体　対　耐　帯　待　怠　態　替　泰　滞　胎　袋　貸　退　逮　隊　代　台　大　第　題　滝　卓　宅　択　拓　沢　濯　託　濁　諾　但　達　奪　脱　棚　谷　丹　単　嘆　担　探　淡　炭　短　端　胆　誕　鍛　団　壇　弾　断　暖　段　男　談　値　知　地　恥　池　痴　稚　置　致　遅　築　畜　竹　蓄　逐　秩　窒　茶　嫡　着　中　仲　宙　忠　抽　昼　柱　注　虫　衷　鋳　駐　著　貯　丁　兆　帳　庁　弔　張　彫　徴　懲　挑　朝　潮　町　眺　聴　脹　腸　調　超　跳　長　頂　鳥　勅　直　朕　沈　珍　賃　鎮　陳　津　墜　追　痛　通　塚　漬　坪　釣　亭　低　停　偵　貞　呈　堤　定　帝　底　庭　廷　弟　抵　提　程　締　艇　訂　逓　邸　泥　摘　敵　滴　的　笛　適　哲　徹　撤　迭　鉄　典　天　展　店　添　転　点　伝　殿　田　電　吐　塗　徒　斗　渡　登　途　都　努　度　土　奴　怒　倒　党　冬　凍　刀　唐　塔　島　悼　投　搭　東　桃　棟　盗　湯　灯　当　痘　等　答　筒　糖　統　到　討　謄　豆　踏　逃　透　陶　頭　騰　闘　働　動　同　堂　導　洞　童　胴　道　銅　峠　匿　得　徳　特　督　篤　毒　独　読　凸　突　届　屯　豚　曇　鈍　内　縄　南　軟　難　二　尼　弐　肉　日　乳　入　如　尿　任　妊　忍　認　寧　猫　熱　年　念　燃　粘　悩　濃　納　能　脳　農　把　覇　波　派　破　婆　馬　俳　廃　拝　排　敗　杯　背　肺　輩　配　倍　培　媒　梅　買　売　賠　陪　伯　博　拍　泊　白　舶　薄　迫　漠　爆　縛　麦　箱　肌　畑　八　鉢　発　髪　伐　罰　抜　閥　伴　判　半　反　帆　搬　板　版　犯　班　畔　繁　般　藩　販　範　煩　頒　飯　晩　番　盤　蛮　卑　否　妃　彼　悲　扉　批　披　比　泌　疲　皮　碑　秘　罷　肥　被　費　避　非　飛　備　尾　微　美　鼻　匹　必　筆　姫　百　俵　標　氷　漂　票　表　評　描　病　秒　苗　品　浜　貧　賓　頻　敏　瓶　不　付　夫　婦　富　布　府　怖　扶　敷　普　浮　父　符　腐　膚　譜　負　賦　赴　附　侮　武　舞　部　封　風　伏　副　復　幅　服　福　腹　複　覆　払　沸　仏　物　分　噴　墳　憤　奮　粉　紛　雰　文　聞　丙　併　兵　塀　幣　平　弊　柄　並　閉　陛　米　壁　癖　別　偏　変　片　編　辺　返　遍　便　勉　弁　保　舗　捕　歩　補　穂　募　墓　慕　暮　母　簿　倣　俸　包　報　奉　宝　峰　崩　抱　放　方　法　泡　砲　縫　胞　芳　褒　訪　豊　邦　飽　乏　亡　傍　剖　坊　妨　帽　忘　忙　房　暴　望　某　棒　冒　紡　肪　膨　謀　貿　防　北　僕　墨　撲　朴　牧　没　堀　奔　本　翻　凡　盆　摩　磨　魔　麻　埋　妹　枚　毎　幕　膜　又　抹　末　繭　万　慢　満　漫　味　未　魅　岬　密　脈　妙　民　眠　務　夢　無　矛　霧　婿　娘　名　命　明　盟　迷　銘　鳴　滅　免　綿　面　模　茂　妄　毛　猛　盲　網　耗　木　黙　目　戻　問　紋　門　匁　夜　野　矢　厄　役　約　薬　訳　躍　柳　愉　油　癒　諭　輸　唯　優　勇　友　幽　悠　憂　有　猶　由　裕　誘　遊　郵　雄　融　夕　予　余　与　誉　預　幼　容　庸　揚　揺　擁　曜　様　洋　溶　用　窯　羊　葉　要　謡　踊　陽　養　抑　欲　浴　翌　翼　羅　裸　来　頼　雷　絡　落　酪　乱　卵　欄　濫　覧　利　吏　履　理　痢　裏　里　離　陸　律　率　立　略　流　留　硫　粒　隆　竜　慮　旅　虜　了　僚　両　寮　料　涼　猟　療　糧　良　量　陵　領　力　緑　倫　厘　林　臨　輪　隣　塁　涙　累　類　令　例　冷　励　礼　鈴　隷　零　霊　麗　齢　暦　歴　列　劣　烈　裂　廉　恋　練　連　錬　炉　路　露　労　廊　朗　楼　浪　漏　老　郎　六　録　論　和　話　賄　惑　枠　湾　腕";
    /** Limited Glyph List for Korean. */
    public String GLYPHS_KO = " … 가 각 간 갇 갈 갉 갊 감 갑 값 갓 갔 강 갖 갗 같 갚 갛 개 객 갠 갤 갬 갭 갯 갰 갱 갸 갹 갼 걀 걋 걍 걔 걘 걜 거 걱 건 걷 걸 걺 검 겁 것 겄 겅 겆 겉 겊 겋 게 겐 겔 겜 겝 겟 겠 겡 겨 격 겪 견 겯 결 겸 겹 겻 겼 경 곁 계 곈 곌 곕 곗 고 곡 곤 곧 골 곪 곬 곯 곰 곱 곳 공 곶 과 곽 관 괄 괆 괌 괍 괏 광 괘 괜 괠 괩 괬 괭 괴 괵 괸 괼 굄 굅 굇 굉 교 굔 굘 굡 굣 구 국 군 굳 굴 굵 굶 굻 굼 굽 굿 궁 궂 궈 궉 권 궐 궜 궝 궤 궷 귀 귁 귄 귈 귐 귑 귓 규 균 귤 그 극 근 귿 글 긁 금 급 긋 긍 긔 기 긱 긴 긷 길 긺 김 깁 깃 깅 깆 깊 까 깍 깎 깐 깔 깖 깜 깝 깟 깠 깡 깥 깨 깩 깬 깰 깸 깹 깻 깼 깽 꺄 꺅 꺌 꺼 꺽 꺾 껀 껄 껌 껍 껏 껐 껑 께 껙 껜 껨 껫 껭 껴 껸 껼 꼇 꼈 꼍 꼐 꼬 꼭 꼰 꼲 꼴 꼼 꼽 꼿 꽁 꽂 꽃 꽈 꽉 꽐 꽜 꽝 꽤 꽥 꽹 꾀 꾄 꾈 꾐 꾑 꾕 꾜 꾸 꾹 꾼 꿀 꿇 꿈 꿉 꿋 꿍 꿎 꿔 꿜 꿨 꿩 꿰 꿱 꿴 꿸 뀀 뀁 뀄 뀌 뀐 뀔 뀜 뀝 뀨 끄 끅 끈 끊 끌 끎 끓 끔 끕 끗 끙 끝 끼 끽 낀 낄 낌 낍 낏 낑 나 낙 낚 난 낟 날 낡 낢 남 납 낫 났 낭 낮 낯 낱 낳 내 낵 낸 낼 냄 냅 냇 냈 냉 냐 냑 냔 냘 냠 냥 너 넉 넋 넌 널 넒 넓 넘 넙 넛 넜 넝 넣 네 넥 넨 넬 넴 넵 넷 넸 넹 녀 녁 년 녈 념 녑 녔 녕 녘 녜 녠 노 녹 논 놀 놂 놈 놉 놋 농 높 놓 놔 놘 놜 놨 뇌 뇐 뇔 뇜 뇝 뇟 뇨 뇩 뇬 뇰 뇹 뇻 뇽 누 눅 눈 눋 눌 눔 눕 눗 눙 눠 눴 눼 뉘 뉜 뉠 뉨 뉩 뉴 뉵 뉼 늄 늅 늉 느 늑 는 늘 늙 늚 늠 늡 늣 능 늦 늪 늬 늰 늴 니 닉 닌 닐 닖 님 닙 닛 닝 닢 다 닥 닦 단 닫 달 닭 닮 닯 닳 담 답 닷 닸 당 닺 닻 닿 대 댁 댄 댈 댐 댑 댓 댔 댕 댜 더 덕 덖 던 덛 덜 덞 덟 덤 덥 덧 덩 덫 덮 데 덱 덴 델 뎀 뎁 뎃 뎄 뎅 뎌 뎐 뎔 뎠 뎡 뎨 뎬 도 독 돈 돋 돌 돎 돐 돔 돕 돗 동 돛 돝 돠 돤 돨 돼 됐 되 된 될 됨 됩 됫 됴 두 둑 둔 둘 둠 둡 둣 둥 둬 뒀 뒈 뒝 뒤 뒨 뒬 뒵 뒷 뒹 듀 듄 듈 듐 듕 드 득 든 듣 들 듦 듬 듭 듯 등 듸 디 딕 딘 딛 딜 딤 딥 딧 딨 딩 딪 따 딱 딴 딸 땀 땁 땃 땄 땅 땋 때 땍 땐 땔 땜 땝 땟 땠 땡 떠 떡 떤 떨 떪 떫 떰 떱 떳 떴 떵 떻 떼 떽 뗀 뗄 뗌 뗍 뗏 뗐 뗑 뗘 뗬 또 똑 똔 똘 똥 똬 똴 뙈 뙤 뙨 뚜 뚝 뚠 뚤 뚫 뚬 뚱 뛔 뛰 뛴 뛸 뜀 뜁 뜅 뜨 뜩 뜬 뜯 뜰 뜸 뜹 뜻 띄 띈 띌 띔 띕 띠 띤 띨 띰 띱 띳 띵 라 락 란 랄 람 랍 랏 랐 랑 랒 랖 랗 래 랙 랜 랠 램 랩 랫 랬 랭 랴 략 랸 럇 량 러 럭 런 럴 럼 럽 럿 렀 렁 렇 레 렉 렌 렐 렘 렙 렛 렝 려 력 련 렬 렴 렵 렷 렸 령 례 롄 롑 롓 로 록 론 롤 롬 롭 롯 롱 롸 롼 뢍 뢨 뢰 뢴 뢸 룀 룁 룃 룅 료 룐 룔 룝 룟 룡 루 룩 룬 룰 룸 룹 룻 룽 뤄 뤘 뤠 뤼 뤽 륀 륄 륌 륏 륑 류 륙 륜 률 륨 륩 륫 륭 르 륵 른 를 름 릅 릇 릉 릊 릍 릎 리 릭 린 릴 림 립 릿 링 마 막 만 많 맏 말 맑 맒 맘 맙 맛 망 맞 맡 맣 매 맥 맨 맬 맴 맵 맷 맸 맹 맺 먀 먁 먈 먕 머 먹 먼 멀 멂 멈 멉 멋 멍 멎 멓 메 멕 멘 멜 멤 멥 멧 멨 멩 며 멱 면 멸 몃 몄 명 몇 몌 모 목 몫 몬 몰 몲 몸 몹 못 몽 뫄 뫈 뫘 뫙 뫼 묀 묄 묍 묏 묑 묘 묜 묠 묩 묫 무 묵 묶 문 묻 물 묽 묾 뭄 뭅 뭇 뭉 뭍 뭏 뭐 뭔 뭘 뭡 뭣 뭬 뮈 뮌 뮐 뮤 뮨 뮬 뮴 뮷 므 믄 믈 믐 믓 미 믹 민 믿 밀 밂 밈 밉 밋 밌 밍 및 밑 바 박 밖 밗 반 받 발 밝 밞 밟 밤 밥 밧 방 밭 배 백 밴 밸 뱀 뱁 뱃 뱄 뱅 뱉 뱌 뱍 뱐 뱝 버 벅 번 벋 벌 벎 범 법 벗 벙 벚 베 벡 벤 벧 벨 벰 벱 벳 벴 벵 벼 벽 변 별 볍 볏 볐 병 볕 볘 볜 보 복 볶 본 볼 봄 봅 봇 봉 봐 봔 봤 봬 뵀 뵈 뵉 뵌 뵐 뵘 뵙 뵤 뵨 부 북 분 붇 불 붉 붊 붐 붑 붓 붕 붙 붚 붜 붤 붰 붸 뷔 뷕 뷘 뷜 뷩 뷰 뷴 뷸 븀 븃 븅 브 븍 븐 블 븜 븝 븟 비 빅 빈 빌 빎 빔 빕 빗 빙 빚 빛 빠 빡 빤 빨 빪 빰 빱 빳 빴 빵 빻 빼 빽 뺀 뺄 뺌 뺍 뺏 뺐 뺑 뺘 뺙 뺨 뻐 뻑 뻔 뻗 뻘 뻠 뻣 뻤 뻥 뻬 뼁 뼈 뼉 뼘 뼙 뼛 뼜 뼝 뽀 뽁 뽄 뽈 뽐 뽑 뽕 뾔 뾰 뿅 뿌 뿍 뿐 뿔 뿜 뿟 뿡 쀼 쁑 쁘 쁜 쁠 쁨 쁩 삐 삑 삔 삘 삠 삡 삣 삥 사 삭 삯 산 삳 살 삵 삶 삼 삽 삿 샀 상 샅 새 색 샌 샐 샘 샙 샛 샜 생 샤 샥 샨 샬 샴 샵 샷 샹 섀 섄 섈 섐 섕 서 석 섞 섟 선 섣 설 섦 섧 섬 섭 섯 섰 성 섶 세 섹 센 셀 셈 셉 셋 셌 셍 셔 셕 션 셜 셤 셥 셧 셨 셩 셰 셴 셸 솅 소 속 솎 손 솔 솖 솜 솝 솟 송 솥 솨 솩 솬 솰 솽 쇄 쇈 쇌 쇔 쇗 쇘 쇠 쇤 쇨 쇰 쇱 쇳 쇼 쇽 숀 숄 숌 숍 숏 숑 수 숙 순 숟 술 숨 숩 숫 숭 숯 숱 숲 숴 쉈 쉐 쉑 쉔 쉘 쉠 쉥 쉬 쉭 쉰 쉴 쉼 쉽 쉿 슁 슈 슉 슐 슘 슛 슝 스 슥 슨 슬 슭 슴 습 슷 승 시 식 신 싣 실 싫 심 십 싯 싱 싶 싸 싹 싻 싼 쌀 쌈 쌉 쌌 쌍 쌓 쌔 쌕 쌘 쌜 쌤 쌥 쌨 쌩 썅 써 썩 썬 썰 썲 썸 썹 썼 썽 쎄 쎈 쎌 쏀 쏘 쏙 쏜 쏟 쏠 쏢 쏨 쏩 쏭 쏴 쏵 쏸 쐈 쐐 쐤 쐬 쐰 쐴 쐼 쐽 쑈 쑤 쑥 쑨 쑬 쑴 쑵 쑹 쒀 쒔 쒜 쒸 쒼 쓩 쓰 쓱 쓴 쓸 쓺 쓿 씀 씁 씌 씐 씔 씜 씨 씩 씬 씰 씸 씹 씻 씽 아 악 안 앉 않 알 앍 앎 앓 암 압 앗 았 앙 앝 앞 애 액 앤 앨 앰 앱 앳 앴 앵 야 약 얀 얄 얇 얌 얍 얏 양 얕 얗 얘 얜 얠 얩 어 억 언 얹 얻 얼 얽 얾 엄 업 없 엇 었 엉 엊 엌 엎 에 엑 엔 엘 엠 엡 엣 엥 여 역 엮 연 열 엶 엷 염 엽 엾 엿 였 영 옅 옆 옇 예 옌 옐 옘 옙 옛 옜 오 옥 온 올 옭 옮 옰 옳 옴 옵 옷 옹 옻 와 왁 완 왈 왐 왑 왓 왔 왕 왜 왝 왠 왬 왯 왱 외 왹 왼 욀 욈 욉 욋 욍 요 욕 욘 욜 욤 욥 욧 용 우 욱 운 울 욹 욺 움 웁 웃 웅 워 웍 원 월 웜 웝 웠 웡 웨 웩 웬 웰 웸 웹 웽 위 윅 윈 윌 윔 윕 윗 윙 유 육 윤 율 윰 윱 윳 융 윷 으 윽 은 을 읊 음 읍 읏 응 읒 읓 읔 읕 읖 읗 의 읜 읠 읨 읫 이 익 인 일 읽 읾 잃 임 입 잇 있 잉 잊 잎 자 작 잔 잖 잗 잘 잚 잠 잡 잣 잤 장 잦 재 잭 잰 잴 잼 잽 잿 쟀 쟁 쟈 쟉 쟌 쟎 쟐 쟘 쟝 쟤 쟨 쟬 저 적 전 절 젊 점 접 젓 정 젖 제 젝 젠 젤 젬 젭 젯 젱 져 젼 졀 졈 졉 졌 졍 졔 조 족 존 졸 졺 좀 좁 좃 종 좆 좇 좋 좌 좍 좔 좝 좟 좡 좨 좼 좽 죄 죈 죌 죔 죕 죗 죙 죠 죡 죤 죵 주 죽 준 줄 줅 줆 줌 줍 줏 중 줘 줬 줴 쥐 쥑 쥔 쥘 쥠 쥡 쥣 쥬 쥰 쥴 쥼 즈 즉 즌 즐 즘 즙 즛 증 지 직 진 짇 질 짊 짐 집 짓 징 짖 짙 짚 짜 짝 짠 짢 짤 짧 짬 짭 짯 짰 짱 째 짹 짼 쨀 쨈 쨉 쨋 쨌 쨍 쨔 쨘 쨩 쩌 쩍 쩐 쩔 쩜 쩝 쩟 쩠 쩡 쩨 쩽 쪄 쪘 쪼 쪽 쫀 쫄 쫌 쫍 쫏 쫑 쫓 쫘 쫙 쫠 쫬 쫴 쬈 쬐 쬔 쬘 쬠 쬡 쭁 쭈 쭉 쭌 쭐 쭘 쭙 쭝 쭤 쭸 쭹 쮜 쮸 쯔 쯤 쯧 쯩 찌 찍 찐 찔 찜 찝 찡 찢 찧 차 착 찬 찮 찰 참 찹 찻 찼 창 찾 채 책 챈 챌 챔 챕 챗 챘 챙 챠 챤 챦 챨 챰 챵 처 척 천 철 첨 첩 첫 첬 청 체 첵 첸 첼 쳄 쳅 쳇 쳉 쳐 쳔 쳤 쳬 쳰 촁 초 촉 촌 촐 촘 촙 촛 총 촤 촨 촬 촹 최 쵠 쵤 쵬 쵭 쵯 쵱 쵸 춈 추 축 춘 출 춤 춥 춧 충 춰 췄 췌 췐 취 췬 췰 췸 췹 췻 췽 츄 츈 츌 츔 츙 츠 측 츤 츨 츰 츱 츳 층 치 칙 친 칟 칠 칡 침 칩 칫 칭 카 칵 칸 칼 캄 캅 캇 캉 캐 캑 캔 캘 캠 캡 캣 캤 캥 캬 캭 컁 커 컥 컨 컫 컬 컴 컵 컷 컸 컹 케 켁 켄 켈 켐 켑 켓 켕 켜 켠 켤 켬 켭 켯 켰 켱 켸 코 콕 콘 콜 콤 콥 콧 콩 콰 콱 콴 콸 쾀 쾅 쾌 쾡 쾨 쾰 쿄 쿠 쿡 쿤 쿨 쿰 쿱 쿳 쿵 쿼 퀀 퀄 퀑 퀘 퀭 퀴 퀵 퀸 퀼 큄 큅 큇 큉 큐 큔 큘 큠 크 큭 큰 클 큼 큽 킁 키 킥 킨 킬 킴 킵 킷 킹 타 탁 탄 탈 탉 탐 탑 탓 탔 탕 태 택 탠 탤 탬 탭 탯 탰 탱 탸 턍 터 턱 턴 털 턺 텀 텁 텃 텄 텅 테 텍 텐 텔 템 텝 텟 텡 텨 텬 텼 톄 톈 토 톡 톤 톨 톰 톱 톳 통 톺 톼 퇀 퇘 퇴 퇸 툇 툉 툐 투 툭 툰 툴 툼 툽 툿 퉁 퉈 퉜 퉤 튀 튁 튄 튈 튐 튑 튕 튜 튠 튤 튬 튱 트 특 튼 튿 틀 틂 틈 틉 틋 틔 틘 틜 틤 틥 티 틱 틴 틸 팀 팁 팃 팅 파 팍 팎 판 팔 팖 팜 팝 팟 팠 팡 팥 패 팩 팬 팰 팸 팹 팻 팼 팽 퍄 퍅 퍼 퍽 펀 펄 펌 펍 펏 펐 펑 페 펙 펜 펠 펨 펩 펫 펭 펴 편 펼 폄 폅 폈 평 폐 폘 폡 폣 포 폭 폰 폴 폼 폽 폿 퐁 퐈 퐝 푀 푄 표 푠 푤 푭 푯 푸 푹 푼 푿 풀 풂 품 풉 풋 풍 풔 풩 퓌 퓐 퓔 퓜 퓟 퓨 퓬 퓰 퓸 퓻 퓽 프 픈 플 픔 픕 픗 피 픽 핀 필 핌 핍 핏 핑 하 학 한 할 핥 함 합 핫 항 해 핵 핸 핼 햄 햅 햇 했 행 햐 향 허 헉 헌 헐 헒 험 헙 헛 헝 헤 헥 헨 헬 헴 헵 헷 헹 혀 혁 현 혈 혐 협 혓 혔 형 혜 혠 혤 혭 호 혹 혼 홀 홅 홈 홉 홋 홍 홑 화 확 환 활 홧 황 홰 홱 홴 횃 횅 회 획 횐 횔 횝 횟 횡 효 횬 횰 횹 횻 후 훅 훈 훌 훑 훔 훗 훙 훠 훤 훨 훰 훵 훼 훽 휀 휄 휑 휘 휙 휜 휠 휨 휩 휫 휭 휴 휵 휸 휼 흄 흇 흉 흐 흑 흔 흖 흗 흘 흙 흠 흡 흣 흥 흩 희 흰 흴 흼 흽 힁 히 힉 힌 힐 힘 힙 힛 힝";
    /** Limited Glyph List for Chinese - Top 99.99%. */
    public String GLYPHS_ZH = "的一是不了 在人有我他这个们中来上大为和国地到以说时要就出会可也你对生能而子那得于着下自之年过发后作里用道行所然家种事成方多经么去法学如都同现当没动面起看定天分还进好小部其些主样理心她本前开但因只从想实日军者意无力它与长把机十民第公此已工使情明性知全三又关点正业外将两高间由问很最重并物手应战向头文体政美相见被利什二等产或新己制身果加西斯月话合回特代内信表化老给世位次度门任常先海通教儿原东声提立及比员解水名真论处走义各入几口认条平系气题活尔更别打女变四神总何电数安少报才结反受目太量再感建务做接必场件计管期市直德资命山金指克许统区保至队形社便空决治展马科司五基眼书非则听白却界达光放强即像难且权思王象完设式色路记南品住告类求据程北边死张该交规万取拉格望觉术领共确传师观清今切院让识候带导争运笑飞风步改收根干造言联持组每济车亲极林服快办议往元英士证近失转夫令准布始怎呢存未远叫台单影具罗字爱击流备兵连调深商算质团集百需价花党华城石级整府离况亚请技际约示复病息究线似官火断精满支视消越器容照须九增研写称企八功吗包片史委乎查轻易早曾除农找装广显吧阿李标谈吃图念六引历首医局突专费号尽另周较注语仅考落青随选列武红响虽推势参希古众构房半节土投某案黑维革划敌致陈律足态护七兴派孩验责营星够章音跟志底站严巴例防族供效续施留讲型料终答紧黄绝奇察母京段依批群项故按河米围江织害斗双境客纪采举杀攻父苏密低朝友诉止细愿千值仍男钱破网热助倒育属坐帝限船脸职速刻乐否刚威毛状率甚独球般普怕弹校苦创假久错承印晚兰试股拿脑预谁益阳若哪微尼继送急血惊伤素药适波夜省初喜卫源食险待述陆习置居劳财环排福纳欢雷警获模充负云停木游龙树疑层冷洲冲射略范竟句室异激汉村哈策演简卡罪判担州静退既衣您宗积余痛检差富灵协角占配征修皮挥胜降阶审沉坚善妈刘读啊超免压银买皇养伊怀执副乱抗犯追帮宣佛岁航优怪香著田铁控税左右份穿艺背阵草脚概恶块顿敢守酒岛托央户烈洋哥索胡款靠评版宝座释景顾弟登货互付伯慢欧换闻危忙核暗姐介坏讨丽良序升监临亮露永呼味野架域沙掉括舰鱼杂误湾吉减编楚肯测败屋跑梦散温困剑渐封救贵枪缺楼县尚毫移娘朋画班智亦耳恩短掌恐遗固席松秘谢鲁遇康虑幸均销钟诗藏赶剧票损忽巨炮旧端探湖录叶春乡附吸予礼港雨呀板庭妇归睛饭额含顺输摇招婚脱补谓督毒油疗旅泽材灭逐莫笔亡鲜词圣择寻厂睡博勒烟授诺伦岸奥唐卖俄炸载洛健堂旁宫喝借君禁阴园谋宋避抓荣姑孙逃牙束跳顶玉镇雪午练迫爷篇肉嘴馆遍凡础洞卷坦牛宁纸诸训私庄祖丝翻暴森塔默握戏隐熟骨访弱蒙歌店鬼软典欲萨伙遭盘爸扩盖弄雄稳忘亿刺拥徒姆杨齐赛趣曲刀床迎冰虚玩析窗醒妻透购替塞努休虎扬途侵刑绿兄迅套贸毕唯谷轮库迹尤竞街促延震弃甲伟麻川申缓潜闪售灯针哲络抵朱埃抱鼓植纯夏忍页杰筑折郑贝尊吴秀混臣雅振染盛怒舞圆搞狂措姓残秋培迷诚宽宇猛摆梅毁伸摩盟末乃悲拍丁赵硬麦蒋操耶阻订彩抽赞魔纷沿喊违妹浪汇币丰蓝殊献桌啦瓦莱援译夺汽烧距裁偏符勇触课敬哭懂墙袭召罚侠厅拜巧侧韩冒债曼融惯享戴童犹乘挂奖绍厚纵障讯涉彻刊丈爆乌役描洗玛患妙镜唱烦签仙彼弗症仿倾牌陷鸟轰咱菜闭奋庆撤泪茶疾缘播朗杜奶季丹狗尾仪偷奔珠虫驻孔宜艾桥淡翼恨繁寒伴叹旦愈潮粮缩罢聚径恰挑袋灰捕徐珍幕映裂泰隔启尖忠累炎暂估泛荒偿横拒瑞忆孤鼻闹羊呆厉衡胞零穷舍码赫婆魂灾洪腿胆津俗辩胸晓劲贫仁偶辑邦恢赖圈摸仰润堆碰艇稍迟辆废净凶署壁御奉旋冬矿抬蛋晨伏吹鸡倍糊秦盾杯租骑乏隆诊奴摄丧污渡旗甘耐凭扎抢绪粗肩梁幻菲皆碎宙叔岩荡综爬荷悉蒂返井壮薄悄扫敏碍殖详迪矛霍允幅撒剩凯颗骂赏液番箱贴漫酸郎腰舒眉忧浮辛恋餐吓挺励辞艘键伍峰尺昨黎辈贯侦滑券崇扰宪绕趋慈乔阅汗枝拖墨胁插箭腊粉泥氏彭拔骗凤慧媒佩愤扑龄驱惜豪掩兼跃尸肃帕驶堡届欣惠册储飘桑闲惨洁踪勃宾频仇磨递邪撞拟滚奏巡颜剂绩贡疯坡瞧截燃焦殿伪柳锁逼颇昏劝呈搜勤戒驾漂饮曹朵仔柔俩孟腐幼践籍牧凉牲佳娜浓芳稿竹腹跌逻垂遵脉貌柏狱猜怜惑陶兽帐饰贷昌叙躺钢沟寄扶铺邓寿惧询汤盗肥尝匆辉奈扣廷澳嘛董迁凝慰厌脏腾幽怨鞋丢埋泉涌辖躲晋紫艰魏吾慌祝邮吐狠鉴曰械咬邻赤挤弯椅陪割揭韦悟聪雾锋梯猫祥阔誉筹丛牵鸣沈阁穆屈旨袖猎臂蛇贺柱抛鼠瑟戈牢逊迈欺吨琴衰瓶恼燕仲诱狼池疼卢仗冠粒遥吕玄尘冯抚浅敦纠钻晶岂峡苍喷耗凌敲菌赔涂粹扁亏寂煤熊恭湿循暖糖赋抑秩帽哀宿踏烂袁侯抖夹昆肝擦猪炼恒慎搬纽纹玻渔磁铜齿跨押怖漠疲叛遣兹祭醉拳弥斜档稀捷肤疫肿豆削岗晃吞宏癌肚隶履涨耀扭坛拨沃绘伐堪仆郭牺歼墓雇廉契拼惩捉覆刷劫嫌瓜歇雕闷乳串娃缴唤赢莲霸桃妥瘦搭赴岳嘉舱俊址庞耕锐缝悔邀玲惟斥宅添挖呵讼氧浩羽斤酷掠妖祸侍乙妨贪挣汪尿莉悬唇翰仓轨枚盐览傅帅庙芬屏寺胖璃愚滴疏萧姿颤丑劣柯寸扔盯辱匹俱辨饿蜂哦腔郁溃谨糟葛苗肠忌溜鸿爵鹏鹰笼丘桂滋聊挡纲肌茨壳痕碗穴膀卓贤卧膜毅锦欠哩函茫昂薛皱夸豫胃舌剥傲拾窝睁携陵哼棉晴铃填饲渴吻扮逆脆喘罩卜炉柴愉绳胎蓄眠竭喂傻慕浑奸扇柜悦拦诞饱乾泡贼亭夕爹酬儒姻卵氛泄杆挨僧蜜吟猩遂狭肖甜霞驳裕顽於摘矮秒卿畜咽披辅勾盆疆赌塑畏吵囊嗯泊肺骤缠冈羞瞪吊贾漏斑涛悠鹿俘锡卑葬铭滩嫁催璇翅盒蛮矣潘歧赐鲍锅廊拆灌勉盲宰佐啥胀扯禧辽抹筒棋裤唉朴咐孕誓喉妄拘链驰栏逝窃艳臭纤玑棵趁匠盈翁愁瞬婴孝颈倘浙谅蔽畅赠妮莎尉冻跪闯葡後厨鸭颠遮谊圳吁仑辟瘤嫂陀框谭亨钦庸歉芝吼甫衫摊宴嘱衷娇陕矩浦讶耸裸碧摧薪淋耻胶屠鹅饥盼脖虹翠崩账萍逢赚撑翔倡绵猴枯巫昭怔渊凑溪蠢禅阐旺寓藤匪伞碑挪琼脂谎慨菩萄狮掘抄岭晕逮砍掏狄晰罕挽脾舟痴蔡剪脊弓懒叉拐喃僚捐姊骚拓歪粘柄坑陌窄湘兆崖骄刹鞭芒筋聘钩棍嚷腺弦焰耍俯厘愣厦恳饶钉寡憾摔叠惹喻谱愧煌徽溶坠煞巾滥洒堵瓷咒姨棒郡浴媚稣淮哎屁漆淫巢吩撰啸滞玫硕钓蝶膝姚茂躯吏猿寨恕渠戚辰舶颁惶狐讽笨袍嘲啡泼衔倦涵雀旬僵撕肢垄夷逸茅侨舆窑涅蒲谦杭噢弊勋刮郊凄捧浸砖鼎篮蒸饼亩肾陡爪兔殷贞荐哑炭坟眨搏咳拢舅昧擅爽咖搁禄雌哨巩绢螺裹昔轩谬谍龟媳姜瞎冤鸦蓬巷琳栽沾诈斋瞒彪厄咨纺罐桶壤糕颂膨谐垒咕隙辣绑宠嘿兑霉挫稽辐乞纱裙嘻哇绣杖塘衍轴攀膊譬斌祈踢肆坎轿棚泣屡躁邱凰溢椎砸趟帘帆栖窜丸斩堤塌贩厢掀喀乖谜捏阎滨虏匙芦苹卸沼钥株祷剖熙哗劈怯棠胳桩瑰娱娶沫嗓蹲焚淘嫩韵衬匈钧竖峻豹捞菊鄙魄兜哄颖镑屑蚁壶怡渗秃迦旱哟咸焉谴宛稻铸锻伽詹毙恍贬烛骇芯汁桓坊驴朽靖佣汝碌迄冀荆崔雁绅珊榜诵傍彦醇笛禽勿娟瞄幢寇睹贿踩霆呜拱妃蔑谕缚诡篷淹腕煮倩卒勘馨逗甸贱炒灿敞蜡囚栗辜垫妒魁谣寞蜀甩涯枕丐泳奎泌逾叮黛燥掷藉枢憎鲸弘倚侮藩拂鹤蚀浆芙垃烤晒霜剿蕴圾绸屿氢驼妆捆铅逛淑榴丙痒钞蹄犬躬昼藻蛛褐颊奠募耽蹈陋侣魅岚侄虐堕陛莹荫狡阀绞膏垮茎缅喇绒搅凳梭丫姬诏钮棺耿缔懈嫉灶匀嗣鸽澡凿纬沸畴刃遏烁嗅叭熬瞥骸奢拙栋毯桐砂莽泻坪梳杉晤稚蔬蝇捣顷麽尴镖诧尬硫嚼羡沦沪旷彬芽狸冥碳咧惕暑咯萝汹腥窥俺潭崎麟捡拯厥澄萎哉涡滔暇溯鳞酿茵愕瞅暮衙诫斧兮焕棕佑嘶妓喧蓉删樱伺嗡娥梢坝蚕敷澜杏绥冶庇挠搂倏聂婉噪稼鳍菱盏匿吱寝揽髓秉哺矢啪帜邵嗽挟缸揉腻驯缆晌瘫贮觅朦僻隋蔓咋嵌虔畔琐碟涩胧嘟蹦冢浏裔襟叨诀旭虾簿啤擒枣嘎苑牟呕骆凸熄兀喔裳凹赎屯膛浇灼裘砰棘橡碱聋姥瑜毋娅沮萌俏黯撇粟粪尹苟癫蚂禹廖俭帖煎缕窦簇棱叩呐瑶墅莺烫蛙歹伶葱哮眩坤廓讳啼乍瓣矫跋枉梗厕琢讥釉窟敛轼庐胚呻绰扼懿炯竿慷虞锤栓桨蚊磅孽惭戳禀鄂馈垣溅咚钙礁彰豁眯磷雯墟迂瞻颅琉悼蝴拣渺眷悯汰慑婶斐嘘镶炕宦趴绷窘襄珀嚣拚酌浊毓撼嗜扛峭磕翘槽淌栅颓熏瑛颐忖牡缀徊梨肪涕惫摹踱肘熔挚氯凛绎庶脯迭睦窍粥庵沧怠沁奕咙氨矗盔拇沛榻揣崭鞘鞠垦洽唾橱仕蜘痰袜峙柬蝉蟹谏鹃擎皓朕疤禺铲酶钝氓匣弧峨锥揪杠吭崛诬冉抒庚悍靡晦醋壕锯夭咦侈婢猾徘硝煽皂舵嗦狈靴捂疮郝苛秽茜搓芸酱赁檐饷蕉铀苔赦缎舷筷朔婪紊厮婿寥兢糙卦槐扒裴祀埔絮芭屉痪霄绽宵邑霖岔饵茄韧琪邹瑚憋殆噜忒忿衅淳悖髦孜粤隘濒铮畸剔坞篱淀蓦唬锣汀趾缉嫦斟鞍扳拴诅谟呃懦逞犁忏拧亥佟叱舜绊龚腮邸椒蔚湛狩眶栈薇肮瀑渣褂叽臀妞巍唔疚鲤戎肇笃辙娴阮札懊焘恤疹潇铝涤恃喽砌遁楞阱咎洼炳噬枫拷哆矶苇翩窒侬靶胰芜辫嚎妾幌踉佃葫皖拽滤睬俞匕谤嗤捍孵倪瘾敝匡磋绫淆尧蕊烘璋亢轧赂蝗榆骏诛勺梵炽笠颌闸狒樊镕垢瘟缪菇琦剃迸溺炫惚嗨陨赃羁臻嘀膳赣踌殉桔瞿闽豚掺沌惰喳椭咪霎侃猝窖戮祠瞩菁躇佬肋咄忡雍忱蕾跄硅伎炊钊蝠屎拭谛褪丞卉隧茸钳啃伢闺舔蹬挛眺袱陇殴柿梧惺弛侥琛捅酝薯曳澈锈稠眸咆簧鸥疡渎汲嬉脓骡穗槛拎巳邢廿搀曙樵隅筛谒倭痹猖佯肛奚甭抨蛾唠荧嵩漱酋攘诘篡睿噩怅盎徙鞅漓祟睫攸翎呛筐堑檀寅磊驭惘吠驮瑙炬痉曝恺胺萤敕筝幡霹竺烙毗鸠埠蒜阜嘈乒帷啄鳌毡阙褥搔笋冕狞韶骼蔼烹奄嫖沐噗岑蛟掳咏弩捻圃孚悴诣呱祁捶钠袄澎氮恪雏撮堰彷鹦晖犀腑沽橄掐亵龋嗒咀祺锚匾乓萃贻揖觑吝憔羌诲砾蠕肴撩坍酥袅黝俾嫣穹秧妊溉鹊聿疙蘑睾楷酵茹锌滇辗纂圭幔褒揍诽倔腓颉锄嗔磺攒瘩雳吆悚墩彝囱逍辄桅俨纶悸殃帧俐绮袒籽孰愫拌橙暨敖赘抉淤剌娼顼葵哝酣麓钵琅簸禾铢璧娠彗惋腋螂阪掣劾沥粱嚓惮氖捎羔俟渲榄茧霓鹉胥琶撬橘醫拈笆痊亟渭狙珂刨蜕谚憧瞟馒拗帚钗哧喋箫刁怦缭迥湄磐渝冗闵噶黏蕃弼驿淄饺踞韬婷唆蜒偎榨漉碉皈矜笈枷鲨蹑瀚酪谑癖烬揩炙蜷侏凋漪悻蹋讪搐碘帛诠碾擂苯诃铎戊荀驹攫憬哽踵蟒漾啧吮楠氟怂叼竣偕漩蹭翌臆挝绚崽糜瘢跤阑恬豢汶跷琵憨蜗螅惴戟匮恙抿桢笺蛤瞳藥瓢衹秤跺潦芹哒饬栩曦骷嫡卤丕鬓梓嗖惦浚咔藐荃唧玺汛铐髅渤皿箍馅汾戍痔褶聆涎汞渍奂巅疣傩逵耆蟋鳄讹膺蹿筏釜沂坯峦茬摒蟀撵浒缤嵋珑苞瑾泵钾暧赓叟佚沓撂蛊甥璐晏瘪漳阉蹂鳃琏湃辘僭躏鼾懵镰寐褚攥涧蝙脐辕涣杞煜骥傣嗳祯酉秸捺瑕鑫馋窿楔胱荔蟆湍屹遐轲镯缰桦炖钡羚啬诩绯掖箓涸鸳塾呸抡擞熹坷瓮亘嗟筵跛汕欤壑颍溥姗踊枭暄稷跚涟瀛笙滕踝贰瞰恻嚏迢獗邯睑赡萦珥酮璞羹缄晾俸媲鸾恿蜿犊讷扈蜈翟藕戌蓓鋆谩谀卯谙岐蝎荼镀椰甄蟾蹊泞撸螃檬猓蔷羲瘸蘸蔗傀蚌锢遽邃恚皑锵簌焙昊鹳睽刽鳖噎呗寰唷殡淖诰恣睐婵榈氦靳蛹鸯惬蹙诙眈罡缮胤皋蛀偌疵绛葆黔喙烽儡佼斓嫔颚龈盅娓坂町芥瘠阂挎橇荟啜垛淇瓒篓虱跻龛蹒髯瞠痫掂潼酰镁灸腆筱谆骋壬茗椋蛔潺扉耘槟雹甬谥淞燎蕙蚪蜻郸轶狰楣捋涓荪娄麝蚤薰醮搪谧湮辍瞌梆樟茉岖臼癣穑玷馍呷萼妩伫彤莓岬媛惆鳎啾囔蜓孺徇徵焊岱昵卅飙邙痞隼恫怆桀绶裆盂桧蚓抠嗷槌痘痢芮蚣闩铿飓疱蝌撅蚯斡窠荚耷砚牒赈煦嗫耙榕鞑袤谌醺秆徨橹翡缨锹嵇圪髻嗬辎痣娩谄蛐鹞翱庖籁蓿鳗疟鲇這嚅瘀颔黜黠濑馁洵忐忑砥咂罹糠匝偃淙纫喏闾祛蛰腼涝曜厩疽闰洄煊汐藓璜铬經渥靼酗苓噤咫椿鲫锭罔锺匍祗锰岌馀畹糯胫熠銮沅棣旌豌孢镭驸腌盹熵镐馐嘤癞骰韭阖瞑裨宕戾镌溟牍隽婊鹄埂拄娲虬萱啵蠡芋胭豺啻褛蛆柠掰篆倌咛蛭谡荨莞澹纭潞郅弋飕螳胄蟑猥宓昙锏蟠過柑烯匐濮蟮祐仄偈蜃箴粼嗥褴蕨蓟圩孪杳魇荤诿簪氲摞飒镂舀夙臧蒿貂蜥蹩噼钛钚獾濂铠皙霭鲈叵霾泯碴鸵峪饕瘁睢鬃迩纣夔垠饨榭隍娑篝榔洌浜鲑谔汩浣舐瞭忻咻鹑唑懋皎诒麾辏氐冽箕俚汴宸芍捱摈摺簦箔咝孀怏谝砧馕耄罂漕沣栾榘烷榷俑沱缜鹫蛳剽衢泗臊瘴酚纾晁孛炀叁憩掬椤啮畿掸镣骁椽侗滦荩泓蚱癜酯體癸蚜扪庑歆蝮蹶弈庋喟滂啕蛎獭槁翊龊邺莘燮剁觐铛谗镍臃墒晔燔嘭涿醯箩鄱睨诤坳鹭砷唏伲猬琥殁蚩泾缥殓鳅氰诋刍芷嶙逅舫呓唰茁馑妫骧苷擢峋袂懑蓑與涞祉踹掇沏诳噫饽饪绺谘飧迳铡枞熨鋈荭赊俦戛湎幺凇芪觯龌挞嬴苻嘁鞯肽恸迨钰儆觎讫滓僮媾龇胯涮绾杈赳斛觥疸卞愠拮庠烨龢菠窈罄囤弁奘咣缫腴缈喵潢遛柚郏荻藜琨镳雉橐陽骈蛉艮搽濡寮柩佗啷诜視偻夯闱谖夥枸膑虻筠埽笞臾婀珞粑怵绻殒觊崂颧嗑榛昱蜴鳝噙淼矾硼囿泅邂钜蠹垩乩嗝淦樽诮揆啐淅榉馗辔暹骛鱿苫犷獠詈竦篙诨铰馄蜚峒滢琬靓狻璨犟鸬螨芩嘹锟蜇洹栉俪钍锨瑁壹痿竑粕犄瘙饯抟衲踮龅愎馥梏讣邝艿趺鲟剜绉罅笥衩姣斫鹗腎爻猕晗铩窕仨搡崴酢檄佞孑璀岷舛邕闿铂霁犒馏阈麋麒苁摁涔宥妍铤锷嗲恽麂赝胛哂撷呶噘懔栎桎霰飨揄噔娣薏忝咤嗵迤贲胪鍪泸蔫刈僖咿鹌嗪茏茯岫嵘轱怼铨昕郢咩馊髡澧苣濯盥囡砺佘谶弑楂翦怩蠼霏楹讴锲慵胝砭潍杵樾帼碣诌徕胴钴裟啶铣铱楫赭碛酊魑醛剐畦陂闶阄祚鹘泱趄骅陲郧倜呤燧铉粲骶峁忸渌骞髭戡钨谲苋锃蜊幄闼戕骊虢烩傥妲绌桠袈鎗薮揿杲肓厝莅氤缙衮诟旖硒唁嬗硎裱颦質靥纥煨礴鏖蝈笏羿鼐湟甑炜煲锉笕喑嶂浔弭妪锂苡孳颏醴間渚轭鹬蚝黃膘邛痨褡耦覃虛馔篾兖阋遨爰痂艄耨沤邋焓秣昶種變窣绦俎榫蟪稗謇氩類锴龉烃俣嬷肱鸢笫痤陰菏莆芨阕砣碜鼹長猷竽舸诓錾淬隗悌姘槭邈婕歙稹蹴砒痈镏羯豕鲂蓖匦笤峥徭浃烊補窸酆缢褓蚨翳趔炔誊赜仃勖葺蚴泷蛴結媸俳诖茑逡孱砦跸祜伉溴屐飚蛞鏡掮崆庾橛矸鸨圻缂蒯诹啭饧镉鸪蛩蠖說劭哐崧杼棂螫龃饔遑颢腱襁忾濠牝蛄鲆嗄灏疥苜荞嘣夤砝颞開忤遢旎瘛魉辇見瓤荥涫娌氚臁毂碇毖壅吡缛玮羟還珈颀虼祇佝翕遴珏郛較驗玖蹇逋氅粽诂岢聒髁黍芾淝鲎鞣髋闳潆汨胍阏钤鹜鬈铵戬點崮枰樯脍畲衾蹼題劬咭囫洱刎芏琊碚鳕谪芎恂槿鲢鲧嘧绀郦噱浠潸跏鲶矍苌抻琰鹚龆臬芄呔雒觞钒饫阒槎鸩舂谠阡莒萸妗稔穰蚧餍谯芗菸葩踔厣佻嘌饩钏蠓黩倨腸缬殚钿鎏恁藿囟鄣呋婺绱瓯旃锶酩恹逶缦鸹螟菟阗濉篑醪鲛讦媪邬殇鄯芡嫠肼峤矽讧掼焖愆聩岘靛菖卟姒杷砉袢蚋笳挈關踽黾麼侩凫诔郯韪挲笪鼋莜風菅嵊裢趿箸莴莠阌旯圜涪赍柞嗍囵榧裰笾簟跎巽曷逖骓绔枋镒魃餮讵乜鄢瑭踅馓蟛鳟荛菬忪阍姹纰桉氪氘垅郃汊娉纡缟旮镢傈堋蔺庥枥腭鹕笮髂魍缁槊跞醚吒枳搿鹧蜍舻鏊禳蒺钹蜢鬻珩卮垭苄苕菀骠袷跹瘘騔論磬缶笸鸷頭芰蕲阆纨琮牦砩蠲锒锕郓妯驷鹩舢趸證養芫嗉蠊笊莸饴阃浯枇焱铆擤柢醢呲崾溆潴牖硪碓鹆鬣堀帙雱須進诎獐桁蛱鳏郴幂箝僳疝茴揶呦嗌囹螈脲镊锑胨膈痼鳊赅贽處苤峄桡雎鲋鞫鼬獯昀痍蟊鞴疖熘乇羸嵴栀槲炝炷硐锸鹂裾侪診調珐縯哔屙旆佰僦牯钪掾針仟圮芟崃廪擘笱跗鲅硷苎匏嗾圄彀粳卣勐掴涑浞玳愍畛赧貉擀湫逦椴铄箧刖鲮訇茱啖悭愀朐畈鹨蛘佶缃晟鲱凼苴颛厍匚徉洙氡胗癯鞒锆佤錢飲細勰钺繇螭嵬轸肟肫邨瘿仞奁宄轳熳睇钼蝼跆樗鲰節诶薜铧裥榇馃術蹚怄寤缗硗碡矬鸱虺糅雠帑镧埙啁悒犍硌锩虿蛑艉钅咴筮艏糁鼍肄籴骜砻蜮龀黢劢腫耪鬯畚觳稞鹁鲲稱捌菔獬柘娆篪鲀谰孬伥谇鄄狎闫滟齑遒磔聃綦鲡蔻泠砗钕镫菹胂煅煸螯躅鲠佥罘嶝適坨菽哞徜慊洳渑灞盍钋鸫踯縻萘褫羰腦俅芤隳洮胼罴镛怛芊啉噌嫱绲膻焐裡葎亓倮莼蘅嘞缒镆網伧荏唳檩鸶蚬骱蘖澍韫颎嘏垡腚焯繻怙羧鼙倥亳艽荠昴舨魈醣枵粜甙珲杓楸楦疃蛏蠛髌茔臨诼嬖耒蜣笄跣钣戆蜉喾铍陉薹肷岵瓴荽怫钭窀缯倬摭帔楝痱蚶螬髑紅鼗狷殛裉粝萋葭衽鳢傧喁嫘罟钌裼愦蝽雖锗衿粢醵跫鐾廛墉哌輕扦堇婧暌罱镞蹰陟鳔脘臟岿侔郾唿砹疴麸薨綝滁偾拊撺呒狯猢椁榱罾铳裎鳚眦璎認崞缇蝣萑狲缱晷冼痧統蕖狍憷锛窨袼帏儋绨疠蘩嵝庀汜炅煳泶瓠窳虮蚰邰苊砀捩蹉莪螽覺蘼槔曛蛲鹾隹犸衄觀轉銎泫玢辊瞋墀酐隱堞尥嚯猗逑逯硖噻嵛畀運鲃偬鄞呖溧嬲肭鹈鹱窭黧谵沆嫒塬缣篯酃喱泔溘迕肀秫裣铋蒌曩赀箪朊鳙仫钎芑胙盱糇挹捭悱鬟緩請崤澶甾欹瞽钇鹪鞔缡铯鲚組嘬庹渖湔玎锜锊舾籼阊祕猊燹葑蓼幛岣浼甯瑷敫钔钫锼锿癔穸褊蚍篦麇樘钯禇铒續莩嵯逭遄戗睃鮈瀣皴泮轫褰炱醍锱篁葚難矇驽辚睥鸺筇戥髀驺頸哙濞逄桤攵炻磙疳醭鳇鹮迓眇楮砜謝離約菘馇栌醐唢獍殳仡軟刿葜薅湓搴尕磴锝镅艚殄暝祢豉垴維瓿煺蟥蹀門黼氙铑積線蒡杪肜膂砬硭酽踟鲷蒴藁猡旒硇锍鞲哿皤哏殍漯確織連谂跶橥镬鸲姝茭窆髟畋溏鲔顯喹紹吣羼缧窬骘赉镓邳璩鸸涠溲孥敉筌義衛響蹓垓苒荸甓锪镄脔艟選達眬彘檠胩旄祆伛鲥荦暾脈納缌飏锞趵跖跬僬皲翥祎貢習閉芴菰眙锓訾莳菪槠榍俜觚撄嵫桴晡爨悫锇锖锘蝾糌柙滹睚辦莨尻罨锔筲妣砘谳钽鈤脹遺鄹菡崦狺杌秭舯豇鲵蘧阚悝铌預缑瑗椹旰魆蓍蕹岜钐锬镪绡檎穀茕話縮顧荈侉渫辂欷轾麴戢趼誤芈苈缍歃燠耜顸蚵哓澌郜徼籀陬蕤叻猞洇锎舳缋镗褙耋聬鳡鲌鰽筆簡計語謂袴巯吖猁桷砼锾颟跽悛桕艨颡髹桫鬆練總膽貝葸屣獒瘌佴锫隰醌萬矯鰕岽昃螓垧廨骺黥豳議絡護釋隨荑莶蓊揎娈嫜毽砑碶剀薷怃怿骐腧霈蝻鵰讀墼坩甏鹇鹣舴鲭傺枘秕糨忉磲顒蟲訓侑萁葳呙鹋貘葶枨棹纛籤規資嶷妁杩鹛羝骖祧給淠畎箨鳐識遠谿剡吲嫫戽糗鸮蕰坼璺栊镝疔瘰谮辋碥豂竅讓黒劂潋孓螋鲳铙塄萆碲粋纻沭祏電鱲頻設試項鄩鱖鱧怍糍鸻仵柰棼氇氆烀镔珉鞬範膠眾鶇囝犴镠觇钆蚺蝓趑貔躞氽绂栲鹎襻蓚貪祓繼脫郿骝檫砟蝰猱缵沔彖黻眢車陳雜驚龍鮠茛蕈骀樨昝餂镎酡鳜觋礅垆坻荇扃磻郗阇腈铈臥顱級階顟衖珙襞劁隈胬纮翙茀荜溱酤腳記許錯鱇圯柽瞀铖粞撙铊圹菝迴岙漶缏貊粫徂洎";
    /** Full Glyph list for Chinese (let's not use: too many characters!). */
    //String GLYPHS_ZH_FULL = " 的一是不了在人有我他这个们中来上大为和国地到以说时要就出会可也你对生能而子那得于着下自之年过发后作里用道行所然家种事成方多经么去法学如都同现当没动面起看定天分还进好小部其些主样理心她本前开但因只从想实日军者意无力它与长把机十民第公此已工使情明性知全三又关点正业外将两高间由问很最重并物手应战向头文体政美相见被利什二等产或新己制身果加西斯月话合回特代内信表化老给世位次度门任常先海通教儿原东声提立及比员解水名真论处走义各入几口认条平系气题活尔更别打女变四神总何电数安少报才结反受目太量再感建务做接必场件计管期市直德资命山金指克许统区保至队形社便空决治展马科司五基眼书非则听白却界达光放强即像难且权思王象完设式色路记南品住告类求据程北边死张该交规万取拉格望觉术领共确传师观清今切院让识候带导争运笑飞风步改收根干造言联持组每济车亲极林服快办议往元英士证近失转夫令准布始怎呢存未远叫台单影具罗字爱击流备兵连调深商算质团集百需价花党华城石级整府离况亚请技际约示复病息究线似官火断精满支视消越器容照须九增研写称企八功吗包片史委乎查轻易早曾除农找装广显吧阿李标谈吃图念六引历首医局突专费号尽另周较注语仅考落青随选列武红响虽推势参希古众构房半节土投某案黑维革划敌致陈律足态护七兴派孩验责营星够章音跟志底站严巴例防族供效续施留讲型料终答紧黄绝奇察母京段依批群项故按河米围江织害斗双境客纪采举杀攻父苏密低朝友诉止细愿千值仍男钱破网热助倒育属坐帝限船脸职速刻乐否刚威毛状率甚独球般普怕弹校苦创假久错承印晚兰试股拿脑预谁益阳若哪微尼继送急血惊伤素药适波夜省初喜卫源食险待述陆习置居劳财环排福纳欢雷警获模充负云停木游龙树疑层冷洲冲射略范竟句室异激汉村哈策演简卡罪判担州静退既衣您宗积余痛检差富灵协角占配征修皮挥胜降阶审沉坚善妈刘读啊超免压银买皇养伊怀执副乱抗犯追帮宣佛岁航优怪香著田铁控税左右份穿艺背阵草脚概恶块顿敢守酒岛托央户烈洋哥索胡款靠评版宝座释景顾弟登货互付伯慢欧换闻危忙核暗姐介坏讨丽良序升监临亮露永呼味野架域沙掉括舰鱼杂误湾吉减编楚肯测败屋跑梦散温困剑渐封救贵枪缺楼县尚毫移娘朋画班智亦耳恩短掌恐遗固席松秘谢鲁遇康虑幸均销钟诗藏赶剧票损忽巨炮旧端探湖录叶春乡附吸予礼港雨呀板庭妇归睛饭额含顺输摇招婚脱补谓督毒油疗旅泽材灭逐莫笔亡鲜词圣择寻厂睡博勒烟授诺伦岸奥唐卖俄炸载洛健堂旁宫喝借君禁阴园谋宋避抓荣姑孙逃牙束跳顶玉镇雪午练迫爷篇肉嘴馆遍凡础洞卷坦牛宁纸诸训私庄祖丝翻暴森塔默握戏隐熟骨访弱蒙歌店鬼软典欲萨伙遭盘爸扩盖弄雄稳忘亿刺拥徒姆杨齐赛趣曲刀床迎冰虚玩析窗醒妻透购替塞努休虎扬途侵刑绿兄迅套贸毕唯谷轮库迹尤竞街促延震弃甲伟麻川申缓潜闪售灯针哲络抵朱埃抱鼓植纯夏忍页杰筑折郑贝尊吴秀混臣雅振染盛怒舞圆搞狂措姓残秋培迷诚宽宇猛摆梅毁伸摩盟末乃悲拍丁赵硬麦蒋操耶阻订彩抽赞魔纷沿喊违妹浪汇币丰蓝殊献桌啦瓦莱援译夺汽烧距裁偏符勇触课敬哭懂墙袭召罚侠厅拜巧侧韩冒债曼融惯享戴童犹乘挂奖绍厚纵障讯涉彻刊丈爆乌役描洗玛患妙镜唱烦签仙彼弗症仿倾牌陷鸟轰咱菜闭奋庆撤泪茶疾缘播朗杜奶季丹狗尾仪偷奔珠虫驻孔宜艾桥淡翼恨繁寒伴叹旦愈潮粮缩罢聚径恰挑袋灰捕徐珍幕映裂泰隔启尖忠累炎暂估泛荒偿横拒瑞忆孤鼻闹羊呆厉衡胞零穷舍码赫婆魂灾洪腿胆津俗辩胸晓劲贫仁偶辑邦恢赖圈摸仰润堆碰艇稍迟辆废净凶署壁御奉旋冬矿抬蛋晨伏吹鸡倍糊秦盾杯租骑乏隆诊奴摄丧污渡旗甘耐凭扎抢绪粗肩梁幻菲皆碎宙叔岩荡综爬荷悉蒂返井壮薄悄扫敏碍殖详迪矛霍允幅撒剩凯颗骂赏液番箱贴漫酸郎腰舒眉忧浮辛恋餐吓挺励辞艘键伍峰尺昨黎辈贯侦滑券崇扰宪绕趋慈乔阅汗枝拖墨胁插箭腊粉泥氏彭拔骗凤慧媒佩愤扑龄驱惜豪掩兼跃尸肃帕驶堡届欣惠册储飘桑闲惨洁踪勃宾频仇磨递邪撞拟滚奏巡颜剂绩贡疯坡瞧截燃焦殿伪柳锁逼颇昏劝呈搜勤戒驾漂饮曹朵仔柔俩孟腐幼践籍牧凉牲佳娜浓芳稿竹腹跌逻垂遵脉貌柏狱猜怜惑陶兽帐饰贷昌叙躺钢沟寄扶铺邓寿惧询汤盗肥尝匆辉奈扣廷澳嘛董迁凝慰厌脏腾幽怨鞋丢埋泉涌辖躲晋紫艰魏吾慌祝邮吐狠鉴曰械咬邻赤挤弯椅陪割揭韦悟聪雾锋梯猫祥阔誉筹丛牵鸣沈阁穆屈旨袖猎臂蛇贺柱抛鼠瑟戈牢逊迈欺吨琴衰瓶恼燕仲诱狼池疼卢仗冠粒遥吕玄尘冯抚浅敦纠钻晶岂峡苍喷耗凌敲菌赔涂粹扁亏寂煤熊恭湿循暖糖赋抑秩帽哀宿踏烂袁侯抖夹昆肝擦猪炼恒慎搬纽纹玻渔磁铜齿跨押怖漠疲叛遣兹祭醉拳弥斜档稀捷肤疫肿豆削岗晃吞宏癌肚隶履涨耀扭坛拨沃绘伐堪仆郭牺歼墓雇廉契拼惩捉覆刷劫嫌瓜歇雕闷乳串娃缴唤赢莲霸桃妥瘦搭赴岳嘉舱俊址庞耕锐缝悔邀玲惟斥宅添挖呵讼氧浩羽斤酷掠妖祸侍乙妨贪挣汪尿莉悬唇翰仓轨枚盐览傅帅庙芬屏寺胖璃愚滴疏萧姿颤丑劣柯寸扔盯辱匹俱辨饿蜂哦腔郁溃谨糟葛苗肠忌溜鸿爵鹏鹰笼丘桂滋聊挡纲肌茨壳痕碗穴膀卓贤卧膜毅锦欠哩函茫昂薛皱夸豫胃舌剥傲拾窝睁携陵哼棉晴铃填饲渴吻扮逆脆喘罩卜炉柴愉绳胎蓄眠竭喂傻慕浑奸扇柜悦拦诞饱乾泡贼亭夕爹酬儒姻卵氛泄杆挨僧蜜吟猩遂狭肖甜霞驳裕顽於摘矮秒卿畜咽披辅勾盆疆赌塑畏吵囊嗯泊肺骤缠冈羞瞪吊贾漏斑涛悠鹿俘锡卑葬铭滩嫁催璇翅盒蛮矣潘歧赐鲍锅廊拆灌勉盲宰佐啥胀扯禧辽抹筒棋裤唉朴咐孕誓喉妄拘链驰栏逝窃艳臭纤玑棵趁匠盈翁愁瞬婴孝颈倘浙谅蔽畅赠妮莎尉冻跪闯葡後厨鸭颠遮谊圳吁仑辟瘤嫂陀框谭亨钦庸歉芝吼甫衫摊宴嘱衷娇陕矩浦讶耸裸碧摧薪淋耻胶屠鹅饥盼脖虹翠崩账萍逢赚撑翔倡绵猴枯巫昭怔渊凑溪蠢禅阐旺寓藤匪伞碑挪琼脂谎慨菩萄狮掘抄岭晕逮砍掏狄晰罕挽脾舟痴蔡剪脊弓懒叉拐喃僚捐姊骚拓歪粘柄坑陌窄湘兆崖骄刹鞭芒筋聘钩棍嚷腺弦焰耍俯厘愣厦恳饶钉寡憾摔叠惹喻谱愧煌徽溶坠煞巾滥洒堵瓷咒姨棒郡浴媚稣淮哎屁漆淫巢吩撰啸滞玫硕钓蝶膝姚茂躯吏猿寨恕渠戚辰舶颁惶狐讽笨袍嘲啡泼衔倦涵雀旬僵撕肢垄夷逸茅侨舆窑涅蒲谦杭噢弊勋刮郊凄捧浸砖鼎篮蒸饼亩肾陡爪兔殷贞荐哑炭坟眨搏咳拢舅昧擅爽咖搁禄雌哨巩绢螺裹昔轩谬谍龟媳姜瞎冤鸦蓬巷琳栽沾诈斋瞒彪厄咨纺罐桶壤糕颂膨谐垒咕隙辣绑宠嘿兑霉挫稽辐乞纱裙嘻哇绣杖塘衍轴攀膊譬斌祈踢肆坎轿棚泣屡躁邱凰溢椎砸趟帘帆栖窜丸斩堤塌贩厢掀喀乖谜捏阎滨虏匙芦苹卸沼钥株祷剖熙哗劈怯棠胳桩瑰娱娶沫嗓蹲焚淘嫩韵衬匈钧竖峻豹捞菊鄙魄兜哄颖镑屑蚁壶怡渗秃迦旱哟咸焉谴宛稻铸锻伽詹毙恍贬烛骇芯汁桓坊驴朽靖佣汝碌迄冀荆崔雁绅珊榜诵傍彦醇笛禽勿娟瞄幢寇睹贿踩霆呜拱妃蔑谕缚诡篷淹腕煮倩卒勘馨逗甸贱炒灿敞蜡囚栗辜垫妒魁谣寞蜀甩涯枕丐泳奎泌逾叮黛燥掷藉枢憎鲸弘倚侮藩拂鹤蚀浆芙垃烤晒霜剿蕴圾绸屿氢驼妆捆铅逛淑榴丙痒钞蹄犬躬昼藻蛛褐颊奠募耽蹈陋侣魅岚侄虐堕陛莹荫狡阀绞膏垮茎缅喇绒搅凳梭丫姬诏钮棺耿缔懈嫉灶匀嗣鸽澡凿纬沸畴刃遏烁嗅叭熬瞥骸奢拙栋毯桐砂莽泻坪梳杉晤稚蔬蝇捣顷麽尴镖诧尬硫嚼羡沦沪旷彬芽狸冥碳咧惕暑咯萝汹腥窥俺潭崎麟捡拯厥澄萎哉涡滔暇溯鳞酿茵愕瞅暮衙诫斧兮焕棕佑嘶妓喧蓉删樱伺嗡娥梢坝蚕敷澜杏绥冶庇挠搂倏聂婉噪稼鳍菱盏匿吱寝揽髓秉哺矢啪帜邵嗽挟缸揉腻驯缆晌瘫贮觅朦僻隋蔓咋嵌虔畔琐碟涩胧嘟蹦冢浏裔襟叨诀旭虾簿啤擒枣嘎苑牟呕骆凸熄兀喔裳凹赎屯膛浇灼裘砰棘橡碱聋姥瑜毋娅沮萌俏黯撇粟粪尹苟癫蚂禹廖俭帖煎缕窦簇棱叩呐瑶墅莺烫蛙歹伶葱哮眩坤廓讳啼乍瓣矫跋枉梗厕琢讥釉窟敛轼庐胚呻绰扼懿炯竿慷虞锤栓桨蚊磅孽惭戳禀鄂馈垣溅咚钙礁彰豁眯磷雯墟迂瞻颅琉悼蝴拣渺眷悯汰慑婶斐嘘镶炕宦趴绷窘襄珀嚣拚酌浊毓撼嗜扛峭磕翘槽淌栅颓熏瑛颐忖牡缀徊梨肪涕惫摹踱肘熔挚氯凛绎庶脯迭睦窍粥庵沧怠沁奕咙氨矗盔拇沛榻揣崭鞘鞠垦洽唾橱仕蜘痰袜峙柬蝉蟹谏鹃擎皓朕疤禺铲酶钝氓匣弧峨锥揪杠吭崛诬冉抒庚悍靡晦醋壕锯夭咦侈婢猾徘硝煽皂舵嗦狈靴捂疮郝苛秽茜搓芸酱赁檐饷蕉铀苔赦缎舷筷朔婪紊厮婿寥兢糙卦槐扒裴祀埔絮芭屉痪霄绽宵邑霖岔饵茄韧琪邹瑚憋殆噜忒忿衅淳悖髦孜粤隘濒铮畸剔坞篱淀蓦唬锣汀趾缉嫦斟鞍扳拴诅谟呃懦逞犁忏拧亥佟叱舜绊龚腮邸椒蔚湛狩眶栈薇肮瀑渣褂叽臀妞巍唔疚鲤戎肇笃辙娴阮札懊焘恤疹潇铝涤恃喽砌遁楞阱咎洼炳噬枫拷哆矶苇翩窒侬靶胰芜辫嚎妾幌踉佃葫皖拽滤睬俞匕谤嗤捍孵倪瘾敝匡磋绫淆尧蕊烘璋亢轧赂蝗榆骏诛勺梵炽笠颌闸狒樊镕垢瘟缪菇琦剃迸溺炫惚嗨陨赃羁臻嘀膳赣踌殉桔瞿闽豚掺沌惰喳椭咪霎侃猝窖戮祠瞩菁躇佬肋咄忡雍忱蕾跄硅伎炊钊蝠屎拭谛褪丞卉隧茸钳啃伢闺舔蹬挛眺袱陇殴柿梧惺弛侥琛捅酝薯曳澈锈稠眸咆簧鸥疡渎汲嬉脓骡穗槛拎巳邢廿搀曙樵隅筛谒倭痹猖佯肛奚甭抨蛾唠荧嵩漱酋攘诘篡睿噩怅盎徙鞅漓祟睫攸翎呛筐堑檀寅磊驭惘吠驮瑙炬痉曝恺胺萤敕筝幡霹竺烙毗鸠埠蒜阜嘈乒帷啄鳌毡阙褥搔笋冕狞韶骼蔼烹奄嫖沐噗岑蛟掳咏弩捻圃孚悴诣呱祁捶钠袄澎氮恪雏撮堰彷鹦晖犀腑沽橄掐亵龋嗒咀祺锚匾乓萃贻揖觑吝憔羌诲砾蠕肴撩坍酥袅黝俾嫣穹秧妊溉鹊聿疙蘑睾楷酵茹锌滇辗纂圭幔褒揍诽倔腓颉锄嗔磺攒瘩雳吆悚墩彝囱逍辄桅俨纶悸殃帧俐绮袒籽孰愫拌橙暨敖赘抉淤剌娼顼葵哝酣麓钵琅簸禾铢璧娠彗惋腋螂阪掣劾沥粱嚓惮氖捎羔俟渲榄茧霓鹉胥琶撬橘醫拈笆痊亟渭狙珂刨蜕谚憧瞟馒拗帚钗哧喋箫刁怦缭迥湄磐渝冗闵噶黏蕃弼驿淄饺踞韬婷唆蜒偎榨漉碉皈矜笈枷鲨蹑瀚酪谑癖烬揩炙蜷侏凋漪悻蹋讪搐碘帛诠碾擂苯诃铎戊荀驹攫憬哽踵蟒漾啧吮楠氟怂叼竣偕漩蹭翌臆挝绚崽糜瘢跤阑恬豢汶跷琵憨蜗螅惴戟匮恙抿桢笺蛤瞳藥瓢衹秤跺潦芹哒饬栩曦骷嫡卤丕鬓梓嗖惦浚咔藐荃唧玺汛铐髅渤皿箍馅汾戍痔褶聆涎汞渍奂巅疣傩逵耆蟋鳄讹膺蹿筏釜沂坯峦茬摒蟀撵浒缤嵋珑苞瑾泵钾暧赓叟佚沓撂蛊甥璐晏瘪漳阉蹂鳃琏湃辘僭躏鼾懵镰寐褚攥涧蝙脐辕涣杞煜骥傣嗳祯酉秸捺瑕鑫馋窿楔胱荔蟆湍屹遐轲镯缰桦炖钡羚啬诩绯掖箓涸鸳塾呸抡擞熹坷瓮亘嗟筵跛汕欤壑颍溥姗踊枭暄稷跚涟瀛笙滕踝贰瞰恻嚏迢獗邯睑赡萦珥酮璞羹缄晾俸媲鸾恿蜿犊讷扈蜈翟藕戌蓓鋆谩谀卯谙岐蝎荼镀椰甄蟾蹊泞撸螃檬猓蔷羲瘸蘸蔗傀蚌锢遽邃恚皑锵簌焙昊鹳睽刽鳖噎呗寰唷殡淖诰恣睐婵榈氦靳蛹鸯惬蹙诙眈罡缮胤皋蛀偌疵绛葆黔喙烽儡佼斓嫔颚龈盅娓坂町芥瘠阂挎橇荟啜垛淇瓒篓虱跻龛蹒髯瞠痫掂潼酰镁灸腆筱谆骋壬茗椋蛔潺扉耘槟雹甬谥淞燎蕙蚪蜻郸轶狰楣捋涓荪娄麝蚤薰醮搪谧湮辍瞌梆樟茉岖臼癣穑玷馍呷萼妩伫彤莓岬媛惆鳎啾囔蜓孺徇徵焊岱昵卅飙邙痞隼恫怆桀绶裆盂桧蚓抠嗷槌痘痢芮蚣闩铿飓疱蝌撅蚯斡窠荚耷砚牒赈煦嗫耙榕鞑袤谌醺秆徨橹翡缨锹嵇圪髻嗬辎痣娩谄蛐鹞翱庖籁蓿鳗疟鲇這嚅瘀颔黜黠濑馁洵忐忑砥咂罹糠匝偃淙纫喏闾祛蛰腼涝曜厩疽闰洄煊汐藓璜铬經渥靼酗苓噤咫椿鲫锭罔锺匍祗锰岌馀畹糯胫熠銮沅棣旌豌孢镭驸腌盹熵镐馐嘤癞骰韭阖瞑裨宕戾镌溟牍隽婊鹄埂拄娲虬萱啵蠡芋胭豺啻褛蛆柠掰篆倌咛蛭谡荨莞澹纭潞郅弋飕螳胄蟑猥宓昙锏蟠過柑烯匐濮蟮祐仄偈蜃箴粼嗥褴蕨蓟圩孪杳魇荤诿簪氲摞飒镂舀夙臧蒿貂蜥蹩噼钛钚獾濂铠皙霭鲈叵霾泯碴鸵峪饕瘁睢鬃迩纣夔垠饨榭隍娑篝榔洌浜鲑谔汩浣舐瞭忻咻鹑唑懋皎诒麾辏氐冽箕俚汴宸芍捱摈摺簦箔咝孀怏谝砧馕耄罂漕沣栾榘烷榷俑沱缜鹫蛳剽衢泗臊瘴酚纾晁孛炀叁憩掬椤啮畿掸镣骁椽侗滦荩泓蚱癜酯體癸蚜扪庑歆蝮蹶弈庋喟滂啕蛎獭槁翊龊邺莘燮剁觐铛谗镍臃墒晔燔嘭涿醯箩鄱睨诤坳鹭砷唏伲猬琥殁蚩泾缥殓鳅氰诋刍芷嶙逅舫呓唰茁馑妫骧苷擢峋袂懑蓑與涞祉踹掇沏诳噫饽饪绺谘飧迳铡枞熨鋈荭赊俦戛湎幺凇芪觯龌挞嬴苻嘁鞯肽恸迨钰儆觎讫滓僮媾龇胯涮绾杈赳斛觥疸卞愠拮庠烨龢菠窈罄囤弁奘咣缫腴缈喵潢遛柚郏荻藜琨镳雉橐陽骈蛉艮搽濡寮柩佗啷诜視偻夯闱谖夥枸膑虻筠埽笞臾婀珞粑怵绻殒觊崂颧嗑榛昱蜴鳝噙淼矾硼囿泅邂钜蠹垩乩嗝淦樽诮揆啐淅榉馗辔暹骛鱿苫犷獠詈竦篙诨铰馄蜚峒滢琬靓狻璨犟鸬螨芩嘹锟蜇洹栉俪钍锨瑁壹痿竑粕犄瘙饯抟衲踮龅愎馥梏讣邝艿趺鲟剜绉罅笥衩姣斫鹗腎爻猕晗铩窕仨搡崴酢檄佞孑璀岷舛邕闿铂霁犒馏阈麋麒苁摁涔宥妍铤锷嗲恽麂赝胛哂撷呶噘懔栎桎霰飨揄噔娣薏忝咤嗵迤贲胪鍪泸蔫刈僖咿鹌嗪茏茯岫嵘轱怼铨昕郢咩馊髡澧苣濯盥囡砺佘谶弑楂翦怩蠼霏楹讴锲慵胝砭潍杵樾帼碣诌徕胴钴裟啶铣铱楫赭碛酊魑醛剐畦陂闶阄祚鹘泱趄骅陲郧倜呤燧铉粲骶峁忸渌骞髭戡钨谲苋锃蜊幄闼戕骊虢烩傥妲绌桠袈鎗薮揿杲肓厝莅氤缙衮诟旖硒唁嬗硎裱颦質靥纥煨礴鏖蝈笏羿鼐湟甑炜煲锉笕喑嶂浔弭妪锂苡孳颏醴間渚轭鹬蚝黃膘邛痨褡耦覃虛馔篾兖阋遨爰痂艄耨沤邋焓秣昶種變窣绦俎榫蟪稗謇氩類锴龉烃俣嬷肱鸢笫痤陰菏莆芨阕砣碜鼹長猷竽舸诓錾淬隗悌姘槭邈婕歙稹蹴砒痈镏羯豕鲂蓖匦笤峥徭浃烊補窸酆缢褓蚨翳趔炔誊赜仃勖葺蚴泷蛴結媸俳诖茑逡孱砦跸祜伉溴屐飚蛞鏡掮崆庾橛矸鸨圻缂蒯诹啭饧镉鸪蛩蠖說劭哐崧杼棂螫龃饔遑颢腱襁忾濠牝蛄鲆嗄灏疥苜荞嘣夤砝颞開忤遢旎瘛魉辇見瓤荥涫娌氚臁毂碇毖壅吡缛玮羟還珈颀虼祇佝翕遴珏郛較驗玖蹇逋氅粽诂岢聒髁黍芾淝鲎鞣髋闳潆汨胍阏钤鹜鬈铵戬點崮枰樯脍畲衾蹼題劬咭囫洱刎芏琊碚鳕谪芎恂槿鲢鲧嘧绀郦噱浠潸跏鲶矍苌抻琰鹚龆臬芄呔雒觞钒饫阒槎鸩舂谠阡莒萸妗稔穰蚧餍谯芗菸葩踔厣佻嘌饩钏蠓黩倨腸缬殚钿鎏恁藿囟鄣呋婺绱瓯旃锶酩恹逶缦鸹螟菟阗濉篑醪鲛讦媪邬殇鄯芡嫠肼峤矽讧掼焖愆聩岘靛菖卟姒杷砉袢蚋笳挈關踽黾麼侩凫诔郯韪挲笪鼋莜風菅嵊裢趿箸莴莠阌旯圜涪赍柞嗍囵榧裰笾簟跎巽曷逖骓绔枋镒魃餮讵乜鄢瑭踅馓蟛鳟荛菬忪阍姹纰桉氪氘垅郃汊娉纡缟旮镢傈堋蔺庥枥腭鹕笮髂魍缁槊跞醚吒枳搿鹧蜍舻鏊禳蒺钹蜢鬻珩卮垭苄苕菀骠袷跹瘘騔論磬缶笸鸷頭芰蕲阆纨琮牦砩蠲锒锕郓妯驷鹩舢趸證養芫嗉蠊笊莸饴阃浯枇焱铆擤柢醢呲崾溆潴牖硪碓鹆鬣堀帙雱須進诎獐桁蛱鳏郴幂箝僳疝茴揶呦嗌囹螈脲镊锑胨膈痼鳊赅贽處苤峄桡雎鲋鞫鼬獯昀痍蟊鞴疖熘乇羸嵴栀槲炝炷硐锸鹂裾侪診調珐縯哔屙旆佰僦牯钪掾針仟圮芟崃廪擘笱跗鲅硷苎匏嗾圄彀粳卣勐掴涑浞玳愍畛赧貉擀湫逦椴铄箧刖鲮訇茱啖悭愀朐畈鹨蛘佶缃晟鲱凼苴颛厍匚徉洙氡胗癯鞒锆佤錢飲細勰钺繇螭嵬轸肟肫邨瘿仞奁宄轳熳睇钼蝼跆樗鲰節诶薜铧裥榇馃術蹚怄寤缗硗碡矬鸱虺糅雠帑镧埙啁悒犍硌锩虿蛑艉钅咴筮艏糁鼍肄籴骜砻蜮龀黢劢腫耪鬯畚觳稞鹁鲲稱捌菔獬柘娆篪鲀谰孬伥谇鄄狎闫滟齑遒磔聃綦鲡蔻泠砗钕镫菹胂煅煸螯躅鲠佥罘嶝適坨菽哞徜慊洳渑灞盍钋鸫踯縻萘褫羰腦俅芤隳洮胼罴镛怛芊啉噌嫱绲膻焐裡葎亓倮莼蘅嘞缒镆網伧荏唳檩鸶蚬骱蘖澍韫颎嘏垡腚焯繻怙羧鼙倥亳艽荠昴舨魈醣枵粜甙珲杓楸楦疃蛏蠛髌茔臨诼嬖耒蜣笄跣钣戆蜉喾铍陉薹肷岵瓴荽怫钭窀缯倬摭帔楝痱蚶螬髑紅鼗狷殛裉粝萋葭衽鳢傧喁嫘罟钌裼愦蝽雖锗衿粢醵跫鐾廛墉哌輕扦堇婧暌罱镞蹰陟鳔脘臟岿侔郾唿砹疴麸薨綝滁偾拊撺呒狯猢椁榱罾铳裎鳚眦璎認崞缇蝣萑狲缱晷冼痧統蕖狍憷锛窨袼帏儋绨疠蘩嵝庀汜炅煳泶瓠窳虮蚰邰苊砀捩蹉莪螽覺蘼槔曛蛲鹾隹犸衄觀轉銎泫玢辊瞋墀酐隱堞尥嚯猗逑逯硖噻嵛畀運鲃偬鄞呖溧嬲肭鹈鹱窭黧谵沆嫒塬缣篯酃喱泔溘迕肀秫裣铋蒌曩赀箪朊鳙仫钎芑胙盱糇挹捭悱鬟緩請崤澶甾欹瞽钇鹪鞔缡铯鲚組嘬庹渖湔玎锜锊舾籼阊祕猊燹葑蓼幛岣浼甯瑷敫钔钫锼锿癔穸褊蚍篦麇樘钯禇铒續莩嵯逭遄戗睃鮈瀣皴泮轫褰炱醍锱篁葚難矇驽辚睥鸺筇戥髀驺頸哙濞逄桤攵炻磙疳醭鳇鹮迓眇楮砜謝離約菘馇栌醐唢獍殳仡軟刿葜薅湓搴尕磴锝镅艚殄暝祢豉垴維瓿煺蟥蹀門黼氙铑積線蒡杪肜膂砬硭酽踟鲷蒴藁猡旒硇锍鞲哿皤哏殍漯確織連谂跶橥镬鸲姝茭窆髟畋溏鲔顯喹紹吣羼缧窬骘赉镓邳璩鸸涠溲孥敉筌義衛響蹓垓苒荸甓锪镄脔艟選達眬彘檠胩旄祆伛鲥荦暾脈納缌飏锞趵跖跬僬皲翥祎貢習閉芴菰眙锓訾莳菪槠榍俜觚撄嵫桴晡爨悫锇锖锘蝾糌柙滹睚辦莨尻罨锔筲妣砘谳钽鈤脹遺鄹菡崦狺杌秭舯豇鲵蘧阚悝铌預缑瑗椹旰魆蓍蕹岜钐锬镪绡檎穀茕話縮顧荈侉渫辂欷轾麴戢趼誤芈苈缍歃燠耜顸蚵哓澌郜徼籀陬蕤叻猞洇锎舳缋镗褙耋聬鳡鲌鰽筆簡計語謂袴巯吖猁桷砼锾颟跽悛桕艨颡髹桫鬆練總膽貝葸屣獒瘌佴锫隰醌萬矯鰕岽昃螓垧廨骺黥豳議絡護釋隨荑莶蓊揎娈嫜毽砑碶剀薷怃怿骐腧霈蝻鵰讀墼坩甏鹇鹣舴鲭傺枘秕糨忉磲顒蟲訓侑萁葳呙鹋貘葶枨棹纛籤規資嶷妁杩鹛羝骖祧給淠畎箨鳐識遠谿剡吲嫫戽糗鸮蕰坼璺栊镝疔瘰谮辋碥豂竅讓黒劂潋孓螋鲳铙塄萆碲粋纻沭祏電鱲頻設試項鄩鱖鱧怍糍鸻仵柰棼氇氆烀镔珉鞬範膠眾鶇囝犴镠觇钆蚺蝓趑貔躞氽绂栲鹎襻蓚貪祓繼脫郿骝檫砟蝰猱缵沔彖黻眢車陳雜驚龍鮠茛蕈骀樨昝餂镎酡鳜觋礅垆坻荇扃磻郗阇腈铈臥顱級階顟衖珙襞劁隈胬纮翙茀荜溱酤腳記許錯鱇圯柽瞀铖粞撙铊圹菝迴岙漶缏貊粫徂洎礌膿葉險雙餘邠邽溽棰舭艋靜聱尢藚佾蕻狁绁牾慝蜱鬘膚虧邊髮埚堙菥萏玟椟铗颙踬筚矻搠圉浍閱蛸礎討鎮鮊芘萜鄗惝毵鲽酞絕哚溷缞踰搦帻铦鲴髫盡蓋製載週陸醡儇狴迮鍬趱椠赟陔坌悃塍疬麈絜脩赒埒镡镨骎骙薑鼩雰穩藴責鮮鳑豨琚觫鲦刳拶掊泐瘗雩麿檗鼂詳際褔铟聽觸靈鲏蒗魟遹攴蝥茆蓁嚆忮篌菧卺郫篠複該貴辯飛犰狳陠蹁蓐稜菃埝蕞喈戋赙磉郤聍铷硏腘興雞鬱鳴麥鮟鳈秾邗釐矧舁貅瞇骢阼垸墁攮柝梃眚箜簏綮鲩諡茇摅顐蜾龂臍膩諸讉鎯脒箬鲻埸颃蒹瞍铫蒐蹻幞阯觏媵钬襦簋翮蹯艖貓鐮負順鲿緊蹠攉禊箐镟癍霪袪劓殂脞霨饾耵泺埤碁鲐鷟膬茲粯糞聲貼陴橼驩唣蜩埯蓥袝谞馘谫輶廑瘐躐黟纔礙膯華藭禆號談費顏飯稓縠揠绐鸰搛黹恧粎柒裒栳钸饸譞販铕絷蒨蓣迻釆鲕頗鍏鷉郄埘薤鲞鼯坭蔌缳靦筸蘋夼椐轹脬眍饹瘥瘵蝦誌邴鉁鞮舄麄翛覩纩蓮唛袓祂轎紀纖輔鉀領螵鸊鮡禛袆謴邾鮣酲龁汔眄眊鬲阨靸臉贇酺狃轺霅鬂鼷蠃埴鴥隊髆綱膮謹铪鹼簳終綜裝訉銀鲉蕿袊汆硃仝趽堍揸忭銧妤頫緡讟龠垤擐噍洫滏璁癃邡絁鍩趨蒽絲膫臅茖蘇詞詾贆蹨農錄鐘鰜鹽赕鯔鯮蔯貙餬躜鳀鹡蠋钲蜁兕阽鎰绋铓爝磾葷螘仂雲顗蟫蕺骃蔀诪猹鋬盤齾埕聞舉虡評鍋陣紬訢蔎繸绖埭駮鰡鵳柁筴珧贳贶腩臌礓袛貐蹐圬堠屦驵鑑桄霑憝瘳騃茌辀胠埏腠靰鞡缻輳闆铼紤翹聯詢課豐賴輸遲鐣齡莤鱯缽邲唼鐻閟駚篥茈肏萩跐蹅瞢罽聭辻铚箦踣菑蹟捃瘕睺閒鈦顩鳓闇鹹禍窩純縱聖聛脮衝訊馬諹誖蕅鰨睒笰籥翧镩耧蜞舡鰲鹀罣觍絽羶臜薙觔躼岈潲枧觌膦礞蝤螗酹醅絅纁葰郇躄茼洧滠澉鎭铏閤赆赇顣骕飑訄輓鉤鋹钘陁耱繫鋵鱵黨禿貧買賈榀緣膶茐螝訙誘賦贅鄬釤鍵閮隻飽齒鯆逿鮀鯝鰁鱤郕镴韻鮄鲙鳁齁舖膹袣謿陧坜坫甍绠恝飗镙镱騾魋硱祫筍箖袧迯郙酖遘阘眭餗耖鯒邶絼颥篚鳘虒裈遆麑粚託鄚軌饋銳粌紙職臏莖葌豬貏違鄉闅闊頂飢驅魚鳉鴱鶎黴祼鬛镈瞓罶羑黉霚笹郐溻骯礡袉訚谉莛哕滗瀹鏰稃眰眳矞硚禋翀苾襕趥茺軿逌唪庳殪隃糈鲄龜碕鲣綎栝轵雔頠穈翃膭衒盇礦譢鳰遞鴫笟莾蒼蟬袑訒講讝購趕鈧鈩閃閷頉髤龤薿鱥觝鮻鳤穉觱轘鐓筘鲝睏蔸镚痦秵臎葴蝟訂泖骟锽犋眵耩筢躔鬏黪祔箠舲蒷蜺襢謺劐貯搋醊廒洚胲韥饘馂筅鳆鲊麗篸腄臑诐仳趩篩簾絪绹膵蕗蝘袠賸葙遊饑驀祪禘臺菍髒軸釘頃仉氕矔緒脅臒苿菢蔂藞袩貞賣跍跓蹤軍邿鄰醿鈨鋼駵駸鰪鱾賨艞鹟钁鞓鰉監穊蕡鑨楱靹鷃鼱眫艆褯剞蔟靿飭瘼酴鼢睆硁秬穪筦粡粣綖裏刭跼蒇挢邆彡猃闉阓阛靺鞨铥瘅駰騻箅箢觖麆齮糀虯瘊絛聴蘭讬揲镮钷睪砲稅翫荅菉袚褋贠跡踦遯鉅鎌靉韲餖鶺麕瞼菵蟭錏踐輾銷閣頁驟碼禎禦稖稟竇笇篂緛編縿舊蓴蕚蘆蝿袃親訴讕讚財贏軅軓釙鉄錆閶鯕鶕麨脭鲯鐏魾眎睞窋籠綠縡縫肅鉏謦麹蔔繐眥粺缊艈蓇蛣蹾掎哜鄦陞韰飖镲麃禑筰聠茷螀袞褧賮赗踡揞遝酂酇醜檑雮氍腙飩痖髣髳酎鲒鲪鹯麜齸齻粩詣隄簰蒾蓏薳藛蚢蓠蓰遡郋鄜錞靣鸂麐麚齧睊砢碻絃茝菴袥襍覗詩諥跂辵邅醨頍疰觜鴿笭糷纘翉胵芖蔣蔦蛚蛯蜏讞賲钃餈馧麤鼶禱臓鈍錫紛遙螣铽竝粊紗紮絺絿緯脦臇臋葍葞葯葻藙蜔螕蟻襲觼觿詼諝貨賀趧跉躍軒輪邉鄶酁釀鈾鈿鍊闀闄腽霧韌頎額顫顬髿鴣鶝鷣齋鋊隤艦譟蒉磜綼輋頨閗鮍鯡鲹禣粏綿臐迏鋾鐇铻鮼鼈込篰痄睄磡窔筊羺腪臢荄蓡蝀詥豀苠郞骒戤铞耢麯秱筼綈翬脧茣菒蓯蕝詝謱冁踧茚辌辒郪鄘鄠帱鈇缲雚雟韺頵顝镘鬋酾鳣鴦麀麉麊麣藬鏘鞚飔鴃齏礄誥醲毳築絫脺苧蚘蝺蠶裀詧貍踘蹷蟓盦瞆矰磥祮稛箾翂胊蓺薾襱覅讏跅踆蹔軐轪鄤醰鑟铔閛陙霳顑镤鵲竚紩聦餅鶄競簷糵紖訪豎趦隸禠籓镥盜矝笖笧簢簻籌粍綍縕罋罷翜膰膲菂葦薢藷螞蠻袀袐覍訌訛詿諄譜豈賢賹遷釛鈣鈱鈶鍛鍦鐵閯閺閻隂頌頰顆顪飼駕駝驌驘鰠鰹鲗鶒鶗鷥鷹齊硙禜糢藠镦蕂霮沩颼禬鴪鮨鱣盝眹睖磫禫繨薦褱鏏鮁鹓繟繺沲餦篤踺祦篲糰絙纄脝茊菫蓞酦醾锳钶鲼齄鴨鷧祋箯粐粦粭紃脰芃苽莿菆藗藧袵裯褵襆詤譓跊軈苘迺掭邇邘鄳猸艴鑕柃闒毹脶颋鵀鶜鶟鷱鷲鹍麖軎稂蒞蠆褲佧紵緌蠾裲郈鋐餱瓞驙鯙眆睠瞫矅碃禃秔穻箇籐絏纕翐耈耎脷膕艐艷苙葹蓂蔲薋蛷蜑衂衋袿訕訝詠誳諆讱軃轝郀郵鉐鍧鍼鏦镵閭闢陗陼韈骫骳骹髠髥鳒鶡龒籂翯莚萗転鄷靭馉騙驊鼰綑績臘臛賜贈蹣軡鋸錐顎瞐銶钖矊矘矚矡硽磿礈礜秲窮竄笗箘箽簍簜粷絨絹緷緻繉繙罁羅羇聣聰脙脛脻脼腗艜萊葘葢蔥藍藘藝蘿蛬螁螚螤袇袌袔袦袨覂訃訋詫詬詮詻誠謬譃譄譯譽賰趮蹱軙軠輩辭遜鄧鄫鄿酀釡釢鉃鍍鍎鎖闃鞗韱頹願顳餁餃餵馮馳駛騎騺鯚鰟鱉鳛鴟鴮鴲鴷鷷鸀麎麡麧鼇鼞鼤齺齽龑裏砮綟緜繑纑罈蠙輴酨鏂駹鎪瞕窪肻蠔鐰綵鮰鳾虰驎荬鑛犏鞧鮋鰷鶲盕盩盻眖砛硈禢禥窼竏筈筽篴籆籇紏肣胑臮苲蒃虗蜌跘鞦驄鷭鸼鹐矄魖鴐薀謏脎締聧脜艤荖蕌蠷褏觽踫蹽軉軛墚搌擗哳鋻楗韂飆饏耥髼篼鬑醑鴧眜瞷磦礨祃祲祻窊簥籲縢繌繒聜胔胾脨膼艕苼莻蓨蓵蓾藦虀蚈蛡蛻蝝蝹蟿衼褦襶覐詯誴諓謧謪譁貤赪踖軆輈鄛鄡醖屺鍑鏉雊顓飐稆駳騽骍筻魱舣鮾鯋鯏鶃鶫齛矙絾袗襬漤闕鬐鲾鴾稭籄聺褹訟鏕齆盫矎礋窌簼糴纴罵翚耰艧藇虖蚖蜎蜨蠭詟詵譔豭趙趬阢圊醃録鍮鍸闚阤霫鞎韗鬖鳠鴼鷇黇黡齣盞眅磈磳穫窅窾筭箣簃簺粴糦絟緺縩罍翣聟肊肙肞臞苶菭葖蕳蚒蜪蝕蠜袕裋裩褌褎襫覈觭訆訏訽詨譻诇貑跱坶躘輖轇轋轕迒郘醄醼鋋鏁鏭鐄鑣鑷辁阸牿鞝頞瞵饤駃駉騠驡髪鬚鬿鮌鯁鱻鶚鷫鹖磩磭稌穃綂膥膱臿艎苃茍蒟藣虈蜐訅詭讈貿趷蹌蹹鈰銑鋫鍔鐨餉騛鯛鰤鳳鵂鶢鶳黋齢磚緲繳聝膴芵藫覓誕誡貎賄跰踥迆逕逤鏢鏤鑄鑽頷鴉鴰麅礱祿缷虙齗裓铹睙矟硣磹礀禮秶窇竷笣篃簬簯粓粶紋紓絞緹縷縼繆繕繚繞绤罆羈翆翑聵脵臄茽莊莢莵菕蓛蓷蓸蔘蔞蕘蕼薔藖藢藶蛢蟯蠄蠈蠎蠣襪覙訑訣詰詸誰諏諛諮諱謥謨譫貋貛貫賓賞贁贂贉趤趯趶跔踴蹆塥輝輰輿轂邁邼釟釠釣鈉鈴鈺鉂銊銘鋤鋭錃錈漭錨鍤鏆鐖鐧鐳鑱鑾镃閬閾閿陜陝霠鞏鞖韨韼韽頒頤顛飳飸餆館饅駐駡駷騁騫騷騼髕魜鰫鱗鱽鲬鴻鶆鶊鷳鷿鸁麞鼏鼜鼫齦盬祅禡禭糱縂蠥軷鄮釱銦錣鑢钑饟鯅鼊簫粛粻饈盌瞂鋅靮盨県箥簕臖鎔鏐顔盿萵蔊覥貲驢鶸磑窎詒鉔鏱隺饜荘蒻蔴裛鈙鎋鑀髴鴓鸴黿秹茢蘁蚑鏻霤霩頺餚鯂籔蕁蘘雑鬶鯵鰧鱂鳂鵟盠盳盽眃眏睧硄碔碦碸磃礘礮祘禤秌秙秢稧稬稲稸穜竒筶篬籒籜籞籶糂糉綡綶緄緗緼縁縋縞繤繧繬纃纉纒纗罯羀耴肍腨膗膟舦艊菄葾蒕蒘蒧蓃蓆蔱蘔蟨蠪襖誇謟讙谽踨躉躱輗釔鋕鎚韆鯶鳋鹒篭縜腣赲馻磞睕瞜碠磽簘腃腵蓳覇醱銝巛鐴鑵隩颺飮飰餇饐痃駞鴜睅睍碭碽磸礉礽祾禌筥簴紣絍縆繀繃羕羵耇聫脗臯艁艂茞葨蒄蒭薂藯蜆螑蟼衟褑褠訐訔詖詗詪諈諑讌豗豷貗貣賯贋冱輀蒈轓迋逓鄺酳鈪尜鐐轷霘鞄騧髽魣鯀鰰鴹鼪龔秊眮笀籣藑垲鍳鵬禔穯茿莂薃襛谻賚魳鵄穄穵篛簑絭緅緍罇耑艒豠蹎辢醻鐍鑮闍頳驈髲鱮麰鼄鼅鼖眣睎瞣矀硊碅磪礒禞秠穙穱窯竢笍筩篳簠粃粖糓糺紭紾絶綅繂繋繣罙罥罼羗羜翭耮聸肸胹脣腬膄膆膋臕舃艫艭艶艼荢荳萚蓗蓱蕋蕟薐薠藺蘓蘪虵蚾蛖蛜蝍蝨蟂蟜蠏衕衘袟袬誾譅譌譸讜趝趡跾踀踸蹡垌蹳躛躩躶軏軬輵轗轥逷遈邌鄟醎釭鈸怊銌鋂鋎鍐鎴鎸鑘閔雋膪霣靃韍颩飦餔駋騄骩骻骾鬙鬽魫鯈鯩鯬鰌鲓鴂鶍鶠鷁鷖鸇鸘鸧鹙麏黮齯龓盓眕睘睩矂矵矺砪硂碒磣祤禩稑穐穛竂笉篟篺紂紻綹緐縈繖繯繴纀羉翈耡腀艩苅莁菞菳萈蒁蒑蓔蓕蔙蔿蕧薆薗薝藀蘌虋蚿蜫蜽螥蠚袽裶裺褣褸詅詇詐誻諧謚豧貮賡賱赑赹赽踃蹞蹧躻躿輻郟鄑酼醁醕醥釪鈵銒銙鋺錗錥鍓鍟鎍鎘鏿鐎鐤鐿鑊锧閧闛隝隥隦靄靱鞪鞺鞿韟顀飀飥飪餒饆馿癀驦髉鬉鬸魛鳷鵋鵏鵨鵼鷵鷼鸍鸓鸖鹠黶鼉齰碀礇禪筣箏糧紐紳綀緱缾羷耊臚艍葏蠅詛誽諂賂輧輽釦鈕鏍鏽鐲颱饝騇髏腂臗眀砫祙祳粧蕣觓趹鄍鈡羭蝄衸謡閏盪眲睋矃矒硟碩磄礂礊祰祹禐秳秼稄稇稈稘稙穢竸竾笐笜筂箒箛箞箤箷箹箿篜簞簤簨簹簽籬粔粸紇紝紺絆絳綄綊綏綒綔綗綴緝緞緦緰緶縣縹繜繝繩纏罃罝罰羴翢聡聹聻聾脕脟脳脽脿臈艑艙艢芻茻荊菐菓菙菚菣菦菨葔葠葮葲蓙蔁蕛蕜蕦蕵蕷薖藨藮藰藳藵虃虘虜虝蛥蛶蜠蝸螐螖螡螢蟳蠌蠍蠒蠗蠝蠟袘褜褨襾覊覚覛覟覠覯訜訡訮証詷詺諉諒諘諦諺謀謠謩謸謽讍讛貦貸貽賅賊賳賺贀贄贊贌趪跁跈跒蹖軀軇軔軘軣軻輒輥輦轟逇邔邥邫鄽醆醞醽釥鈂鈽鉍鉛銓銜鋇鋒鋰鋷錠錦鎲鏈鏟鐑鐬鑲鑴鑿镻閑閰閳閴閹闌闡陮陻霂靵鞊鞛韓韴韷頊頋頓頜顕顨顴飷飺飾餀餌餓饒饡饳饻馴駜駣駥駨駶騰騿驁驇驑驕驖驥髞鬀鬄鬅鬢鬧魰魵魸魺鯊鯐鯓鯖鯗鰞鰬鰵鰸鰻鱌鱺鳩鳪鳶鴭鴳鴴鴵鴺鴽鵁鵝鶈鶐鶓鶩鶴鷩鷴鷽麩麵鼑鼘鼮齲齼龝禖禵秅竌籙粵緋羠翖艣蚡訹諠輂輨遶鈆鈖銅鍥鎇绗鐷閽闟韮騣髧鴢鷘黺祶荮瞏稴笲笿縪纍翸肧臶蜸豊賁輐輘邏雘鯽眞睴瞡砏磯粿紘舋葋薭虲蠩覵註詄譗趰軧岍鉼鋪鞻颵餼騍驂鯘鳿龎睉砤礑禰窤竈聶蕒説趌踄鑰隣饌驛骿鼥碵竤絒絓芼萢蓧蔄螦詀躦狨錋鎝鐩隲霝鞟礐禗稡穽糮羮肰艸葇葟蒪蝑螧蟅蟢貒銫関礤鮭鴙鴞鵣鵪鷦鷺齜盢眘瞞礿祩禨秺穟窫笎篨籋緤緵縚繿羙蘂蜼襘訞謄谼躒躭迍釿鏸颻餟餫餽驆鬳魒盉睱睻磠箋絣縀縛縧荙莕莙螠蟧襌襽豰賷鉽銲錧鍚鍱骣鑪靷頦騊骔魽魿鮅鮇鮎鮘鮪鯨鰿鱀鱄鱓鲖鴒";
    /** Arabic Glyph List. */
    public String GLYPHS_AR = "،؍؎؏؟٭۝ ۞۩﴾﴿أ‎أ‎ـأ‎ب‎ﺏ‎ـب‎ـبـ‎بـ‎ت‎ﺕ‎ـت‎ـتـ‎تـ‎ث‎ﺙ‎ـث‎ـثـ‎ثـ‎ج‎ﺝ‎ـج‎ـجـ‎جـ‎ح‎ﺡ‎ـح‎ـحـ‎حـ‎خ‎ﺥ‎ـخ‎ـخـ‎خـ‎د‎ﺩ‎ـد‎ذ‎ﺫ‎ـذ‎ر‎ﺭ‎ـر‎ز‎ﺯ‎ـز‎س‎ﺱ‎ـس‎ـسـ‎سـ‎ش‎ﺵ‎ـش‎ـشـ‎شـ‎ص‎ﺹ‎ـص‎ـصـ‎صـ‎ض‎ﺽ‎ـض‎ـضـ‎ضـ‎ط‎ﻁ‎ـط‎ـطـ‎طـ‎ظ‎ﻅ‎ـظ‎ـظـ‎ظـ‎ع‎ﻉ‎ـع‎ـعـ‎عـ‎غ‎ﻍ‎ـغ‎ـغـ‎غـ‎ف‎ف‎ـف‎ـفـ‎فـ‎ق‎ﻕ‎ـق‎ـقـ‎قـ‎ك‎ﻙ‎ـك‎ـكـ‎كـ‎ل‎ﻝ‎ـل‎ـلـ‎لـ‎م‎ﻡ‎ـم‎ـمـ‎مـ‎ن‎ن‎ـن‎ـنـ‎نـ‎ﻫ‎ﻩ‎ـه‎ـهـ‎هـ‎و‎ﻭ‎ـو‎ي‎ﻱ‎ـي‎ـيـ‎يـ‎آ‎ﺁ‎ـآ‎ة‎ﺓ‎ـة‎—ى‎ﻯ‎ـى‎";

    public String language = "";

    //public String glyps = this.oi();

    // 13008 da merda

    //public String glyps = DEFAULT_GLYPHS + GLYPHS_JA + GLYPHS_KO;

    public String glyps =
            /* latin */ this.getGlyphs(33,128)
            + /* latin 2*/ this.getGlyphs(161,256)
            + /*greek*/ this.getGlyphs(880,1024)
            + /*cyrillic*/ this.getGlyphs(1024,1080)
            + /*georgian*/ this.getGlyphs(4256,4352)
            //+ /*arabic*/ this.getGlyphs(1536,1792)
            //+ /*hebrew*/ this.getGlyphs(1424,1536)
            + /*armenian*/ this.getGlyphs(1328,1424)
            + /*india*/ this.getGlyphs(2304,2432)
            + /*thai*/ this.getGlyphs(3584,3712);
            //this.getGlyphs(0,4000)
            //+ /*chinese*/ this.getGlyphs(11904,12020)
            //+ /*chinese 1-2*/ this.getGlyphs(12032,12246)
            //+ /*chinese 2*/ this.getGlyphs(12736,12771)
            //+ /*chinese 3*/ this.getGlyphs(13312,16384)
            //+ /*chinese 4*/ this.getGlyphs(16384,19894)
            //+ /*chinese 5*/ this.getGlyphs(19968,20480)
            //+ /*chinese 6*/ this.getGlyphs(20480,24576)
            //+ /*chinese 7*/ this.getGlyphs(24576,28672)
            //+ /*chinese 8*/ this.getGlyphs(28672,32768)
            //+ /*japanese*/ this.getGlyphs(12353,12544)
            //+ /*japanese 2*/ this.getGlyphs(12688,12704)
            //+ /*japanese 3*/ this.getGlyphs(12784,12800);
            //+ /*korean*/ this.getGlyphs(4352,4608)
            //+ /*korean 2*/ this.getGlyphs(12592,12688)
            //+ /*korean 3*/ this.getGlyphs(109568,120740);

    //public String oi = this.getGlyphs(19800,50000);

    public String glypsJapan =
            /*japanese*/ this.getGlyphs(12353,12544)
            + /*japanese 2*/ this.getGlyphs(12688,12704)
            + /*japanese 3*/ this.getGlyphs(12784,12800);

    public String glypsKorea =
            /*korean*/ this.getGlyphs(4352,4608)
            + /*korean 2*/ this.getGlyphs(12592,12688)
            + /*korean 3*/ this.getGlyphs(109568,120740);

    public String glypsChina =
            /*chinese*/ this.getGlyphs(11904,12020)
            + /*chinese 1-2*/ this.getGlyphs(12032,12246)
            + /*chinese 2*/ this.getGlyphs(12736,12771)
            + /*chinese 3*/ this.getGlyphs(13312,16384);
            //+ /*chinese 4*/ this.getGlyphs(16384,19894);
            //+ /*chinese 5*/ this.getGlyphs(19968,20480)
            //+ /*chinese 6*/ this.getGlyphs(20480,24576)
            //+ /*chinese 7*/ this.getGlyphs(24576,28672)
            //+ /*chinese 8*/ this.getGlyphs(28672,32768);

    //public String glypsArabia = this.getGlyphs(150001,200000);

    // Fonts
    public BitmapFont fontDEFAULT;
    public BitmapFont fontJAPAN;
    public BitmapFont fontKOREA;
    public BitmapFont fontCHINA;
    public BitmapFont fontARABIA;

    public BitmapFont fontTopLevelDEFAULT;
    public BitmapFont fontTopLevelJAPAN;
    public BitmapFont fontTopLevelKOREA;
    public BitmapFont fontTopLevelCHINA;
    public BitmapFont fontTopLevelARABIA;

    public BitmapFont fontTopLevelNumberDEFAULT;
    public BitmapFont fontTopLevelNumberJAPAN;
    public BitmapFont fontTopLevelNumberKOREA;
    public BitmapFont fontTopLevelNumberCHINA;
    public BitmapFont fontTopLevelNumberARABIA;

    public BitmapFont fontPlayerSelecionadoLevelDEFAULT;
    public BitmapFont fontPlayerSelecionadoLevelJAPAN;
    public BitmapFont fontPlayerSelecionadoLevelKOREA;
    public BitmapFont fontPlayerSelecionadoLevelCHINA;
    public BitmapFont fontPlayerSelecionadoLevelARABIA;

    public BitmapFont fontSuccessDEFAULT;
    public BitmapFont fontSuccessJAPAN;
    public BitmapFont fontSuccessKOREA;
    public BitmapFont fontSuccessCHINA;
    public BitmapFont fontSuccessARABIA;

    public BitmapFont fontErrorDEFAULT;
    public BitmapFont fontErrorJAPAN;
    public BitmapFont fontErrorKOREA;
    public BitmapFont fontErrorCHINA;
    public BitmapFont fontErrorARABIA;

    public BitmapFont fontTitleDEFAULT;
    public BitmapFont fontTitleJAPAN;
    public BitmapFont fontTitleKOREA;
    public BitmapFont fontTitleCHINA;
    public BitmapFont fontTitleARABIA;

    public FreeTypeFontGenerator generatorDEFAULT;
    public FreeTypeFontGenerator generatorJAPAN;
    public FreeTypeFontGenerator generatorKOREA;
    public FreeTypeFontGenerator generatorCHINA;
    public FreeTypeFontGenerator generatorARABIA;

    public String oi () {

        String glyps = "";

        try {
            //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //ge.registerFont(java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, new File("A.ttf")));

            final java.awt.Font f = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, this.getClass().getClassLoader().getResourceAsStream("android/assets/fonts/default/fontDEFAULT.ttf"));

            for (char c = 0x0000; c <= 0xFFFF; c++) {
                if (f.canDisplay(c)) {
                    System.out.println( c );
                    glyps += " " + c;
                }
            }


        } catch (IOException e) {
            System.out.println( e );
        } catch (FontFormatException e) {
            System.out.println( e );
        }

        return glyps;
    }

    public String getGlyphs (int ini, int fim) {

        String glyps = "";
        //System.out.println( ini );

        for( int i = ini; i < fim; i++ ){
            //Character c = (char)i;
            //System.out.println((char)13008);
                    //if (c.equals('�')) continue;
            //if(Character.isDefined((char)i)) {
                //System.out.println( "Pos:" + i + "Char: " + (char)i);
            //System.out.println( "\\u" + Integer.toHexString((char)i | 0x10000).substring(1) );
            //System.out.println((char)i);
                glyps += (char)i;
                //glyps += " \\u" + Integer.toHexString((char)i | 0x10000).substring(1);
            //}
        }
        //System.out.println("oi: "+glyps);

        //String texto1 = "abc";


        /*
            System.out.println( "Char: " + Integer.toHexString( i )
                    + " ==> " + (char)i );
         */


        /*
        for (int i=0; i<=200000; i++) {
            if (Character.isDefined(i)) {
               // System.out.println(Integer.toHexString(i)+": "+ new String(Character.toChars(i)));
                //Integer.toString(i);
                glyps += new String(Character.toChars(i));
            }
        }
        /
         */
        //System.out.println("lol: "+glyps);
        return glyps;
    }


    public void dispose () {

        generatorDEFAULT.dispose();
        generatorJAPAN.dispose();
        generatorKOREA.dispose();
        generatorCHINA.dispose();
        generatorARABIA.dispose();

        fontDEFAULT.dispose();
        fontJAPAN.dispose();
        fontKOREA.dispose();
        fontCHINA.dispose();
        fontARABIA.dispose();

        fontTopLevelDEFAULT.dispose();
        fontTopLevelJAPAN.dispose();
        fontTopLevelKOREA.dispose();
        fontTopLevelCHINA.dispose();
        fontTopLevelARABIA.dispose();

        fontTopLevelNumberDEFAULT.dispose();
        fontTopLevelNumberJAPAN.dispose();
        fontTopLevelNumberKOREA.dispose();
        fontTopLevelNumberCHINA.dispose();
        fontTopLevelNumberARABIA.dispose();

        fontPlayerSelecionadoLevelDEFAULT.dispose();
        fontPlayerSelecionadoLevelJAPAN.dispose();
        fontPlayerSelecionadoLevelKOREA.dispose();
        fontPlayerSelecionadoLevelCHINA.dispose();
        fontPlayerSelecionadoLevelARABIA.dispose();

        fontSuccessDEFAULT.dispose();
        fontSuccessJAPAN.dispose();
        fontSuccessKOREA.dispose();
        fontSuccessCHINA.dispose();
        fontSuccessARABIA.dispose();

        fontErrorDEFAULT.dispose();
        fontErrorJAPAN.dispose();
        fontErrorKOREA.dispose();
        fontErrorCHINA.dispose();
        fontErrorARABIA.dispose();

        fontTitleDEFAULT.dispose();
        fontTitleJAPAN.dispose();
        fontTitleKOREA.dispose();
        fontTitleCHINA.dispose();
        fontTitleARABIA.dispose();

    }
}
