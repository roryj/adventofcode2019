part1()
part2()

fun part1() {
    val min = 134_564
    val max = 585_159

    var possiblePasswords = HashSet<Int>()
    for (i in min..max) {
        println("testing $i")
        if (isPossiblePassword(i)) {
            println("success! valid number")
            possiblePasswords.add(i)
        }
    }

    println("possible passwords/total combinations: ${possiblePasswords.size}/${max-min + 1}")
}

fun part2() {
    val passwordOptions = listOf<Int>(233479, 233478, 233477, 155666, 245779, 155667, 245778, 233489, 245777, 233488, 335889, 335888, 155668, 155669, 233499, 339999, 155678, 155679, 335899, 155677, 245788, 245799, 155688, 155689, 466999, 155699, 167999, 233555, 233559, 233558, 233557, 233556, 233567, 233566, 233569, 233568, 233579, 233578, 233577, 233589, 233588, 335999, 233599, 155778, 155779, 245889, 155777, 245888, 245899, 249999, 155788, 458889, 155789, 458888, 458899, 155799, 233667, 233666, 233669, 233668, 446668, 446669, 233679, 446666, 233678, 446667, 233677, 237779, 446678, 237778, 446679, 237777, 446677, 233689, 233688, 237789, 237788, 233699, 237799, 446688, 446689, 245999, 446699, 458999, 155888, 155889, 577788, 577789, 155899, 577777, 577778, 577779, 368889, 159999, 368888, 368899, 577799, 225555, 225559, 225558, 225557, 225556, 499999, 225567, 225566, 225569, 225568, 225579, 225578, 225577, 233779, 233778, 233777, 225589, 225588, 356669, 356668, 225599, 446778, 446779, 233789, 356667, 233788, 356666, 446777, 147778, 356677, 147779, 237889, 356679, 446788, 147777, 237888, 356678, 446789, 233799, 237899, 446799, 147788, 147789, 356689, 147799, 356688, 155999, 356699, 368999, 577899, 577888, 577889, 278888, 278889, 278899, 344445, 344444, 344447, 344446, 225667, 135555, 225666, 344455, 135558, 344449, 135559, 344448, 135556, 225669, 135557, 225668, 135566, 225679, 344457, 135567, 225678, 344456, 225677, 344459, 344458, 344469, 344468, 135568, 135569, 344467, 344466, 135578, 344477, 135579, 225689, 344479, 135577, 225688, 344478, 225699, 233889, 233888, 135588, 135589, 233899, 266668, 266669, 237999, 344489, 356777, 135599, 344488, 266666, 356779, 446888, 266667, 356778, 446889, 266677, 356788, 147888, 266678, 147889, 266679, 446899, 344499, 147899, 356799, 266688, 266689, 577999, 266699, 278999, 188888, 188889, 188899, 344557, 344556, 344559, 344558, 344555, 135666, 225779, 135667, 225778, 225777, 344567, 344566, 135668, 135669, 344569, 344568, 225789, 135677, 225788, 225799, 344577, 344579, 344578, 344589, 344588, 135688, 233999, 135699, 446999, 344599, 356889, 147999, 266777, 356888, 266778, 266779, 266788, 266789, 356899, 266799, 188999, 344669, 344668, 344667, 344666, 135778, 344677, 135779, 225889, 344679, 135777, 225888, 344678, 225899, 229999, 135788, 344689, 135799, 344688, 344699, 356999, 569999, 266888, 266889, 266899, 225999, 344777, 344779, 344778, 344789, 344788, 135888, 135889, 557788, 557789, 135899, 557777, 344799, 557778, 557779, 348889, 139999, 348888, 348899, 557799, 266999, 479999, 336669, 336668, 336667, 336666, 336677, 336679, 336678, 336689, 336688, 344889, 135999, 344888, 336699, 348999, 557899, 467779, 467778, 344899, 467777, 557888, 557889, 258889, 467789, 258888, 467788, 258899, 467799, 389999, 455558, 455559, 455556, 455557, 455555, 246667, 455566, 246666, 455567, 336777, 246669, 336779, 246668, 336778, 336789, 336788, 246679, 246678, 246677, 455568, 455569, 336799, 455578, 455579, 455577, 246689, 344999, 455588, 246688, 455589, 557999, 246699, 455599, 258999, 377777, 377779, 467889, 377778, 467888, 377789, 377788, 168888, 168889, 467899, 168899, 377799, 234447, 234446, 234445, 234444, 234449, 234448, 234455, 234459, 234458, 234457, 234456, 299999, 234467, 234466, 234469, 234468, 234479, 234478, 234477, 455668, 455669, 455666, 455667, 156666, 246779, 455678, 156667, 246778, 455679, 234489, 246777, 234488, 455677, 336889, 336888, 156668, 156669, 234499, 156678, 156679, 336899, 156677, 246788, 222223, 246799, 222222, 455688, 455689, 222227, 222226, 156688, 222225, 156689, 222224, 455699, 222229, 222228, 222235, 467999, 156699, 222234, 222233, 222239, 222238, 222237, 222236, 222247, 377889, 168999, 222246, 377888, 222245, 222244, 222249, 222248, 222255, 377899, 222259, 222258, 222257, 222256, 222267, 234555, 222266, 144446, 234559, 144447, 234558, 144444, 222269, 234557, 144445, 222268, 234556, 144448, 144449, 222279, 144455, 222278, 234566, 222277, 144458, 144459, 144456, 144457, 144466, 144467, 222289, 234577, 222288, 144468, 144469, 222299, 144478, 144479, 144477, 234588, 336999, 234599, 455778, 455779, 455777, 156778, 156779, 144488, 246889, 455788, 144489, 156777, 246888, 455789, 246899, 144499, 455799, 156788, 222335, 156799, 222334, 222333, 222339, 222338, 222337, 222336, 222347, 222346, 222345, 377999, 222344, 222349, 222348, 222355, 222359, 222358, 222357, 222356, 222367, 222366, 222369, 222368, 222379, 234667, 144555, 222378, 234666, 222377, 144558, 144559, 144556, 234669, 144557, 234668, 144566, 144567, 222389, 234677, 222388, 144568, 144569, 222399, 144578, 144579, 144577, 234688, 234699, 144588, 144589, 246999, 144599, 455888, 455889, 459999, 156888, 156889, 455899, 156899, 222447, 222446, 222445, 222444, 222449, 222448, 222455, 222459, 222458, 222457, 222456, 222467, 222466, 222469, 222468, 222479, 222478, 222477, 144666, 234779, 144667, 234778, 222489, 234777, 222488, 144668, 144669, 222499, 144678, 447778, 144679, 447779, 144677, 234788, 447777, 238889, 447788, 238888, 447789, 234799, 238899, 447799, 144688, 144689, 144699, 455999, 578888, 578889, 156999, 369999, 222555, 578899, 222559, 222558, 222557, 222556, 222567, 222566, 226667, 226666, 222569, 222568, 226669, 226668, 222579, 222578, 222577, 226679, 226678, 226677, 222589, 222588, 226689, 566666, 226688, 566667, 222599, 566668, 566669, 144778, 226699, 144779, 234889, 144777, 234888, 234899, 238999, 357777, 144788, 357779, 447888, 144789, 357778, 447889, 357789, 357788, 148888, 148889, 144799, 447899, 566677, 566678, 566679, 148899, 357799, 566699, 566688, 566689, 279999, 488889, 488888, 578999, 488899, 222667, 222666, 222669, 222668, 345557, 345556, 345559, 345558, 222679, 222678, 222677, 345555, 136666, 226779, 136667, 226778, 226777, 345567, 345566, 136668, 136669, 222689, 222688, 136678, 345569, 136679, 345568, 226789, 136677, 226788, 222699, 226799, 345577, 345579, 345578, 345589, 345588, 566777, 136688, 566778, 136689, 566779, 234999, 136699, 447999, 144888, 345599, 144889, 144899, 357889, 148999, 267777, 357888, 267778, 267779, 566799, 267788, 267789, 566788, 566789, 357899, 333333, 333335, 267799, 333334, 333337, 333336, 333339, 333338, 333349, 488999, 333348, 333345, 333344, 333347, 333346, 333357, 333356, 333359, 333358, 189999, 333355, 333367, 333366, 222779, 222778, 222777, 333369, 333368, 255555, 345669, 345668, 255559, 333377, 255558, 222789, 255557, 333379, 345667, 222788, 255556, 333378, 345666, 136778, 333389, 345677, 136779, 333388, 226889, 136777, 226888, 222799, 255567, 255566, 226899, 255569, 333399, 255568, 136788, 255579, 255578, 255577, 136799, 345688, 566888, 566889, 144999, 255589, 345699, 255588, 357999, 255599, 177778, 177779, 177777, 267888, 267889, 566899, 177788, 177789, 267899, 333445, 333444, 333447, 333446, 177799, 333455, 333449, 333448, 333457, 333456, 333459, 333458, 333469, 333468, 333467, 333466, 333477, 333479, 333478, 222889, 222888, 222899, 255667, 255666, 226999, 333489, 345777, 333488, 255669, 345779, 255668, 345778, 345788, 136888, 136889, 255679, 255678, 255677, 333499, 136899, 345799, 255689, 255688, 255699, 267999, 566999, 177888, 177889, 177899, 333557, 333556, 333559, 333558, 333555, 333567, 333566, 333569, 333568, 333577, 333579, 333578, 333589, 333588, 222999, 333599, 255779, 558888, 255778, 558889, 255777, 345889, 136999, 345888, 349999, 255789, 345899, 255788, 255799, 558899, 177999, 333669, 333668, 333667, 333666, 333677, 333679, 333678, 337777, 337779, 337778, 337789, 337788, 333689, 333688, 337799, 333699, 345999, 255889, 255888, 255899, 259999, 468889, 468888, 558999, 468899, 333777, 333779, 333778, 333789, 333788, 456668, 456669, 456666, 456667, 247779, 456678, 247778, 456679, 247777, 333799, 456677, 337889, 337888, 247789, 337899, 247788, 247799, 456688, 456689, 255999, 456699, 468999, 378889, 169999, 378888, 378899, 444446, 444447, 444444, 444445, 235555, 444455, 235559, 235558, 235557, 444448, 235556, 444449, 235567, 444458, 235566, 444459, 444456, 444457, 235569, 444468, 235568, 444469, 444466, 444467, 235579, 444478, 235578, 444479, 235577, 444477, 333889, 333888, 235589, 235588, 366669, 366668, 337999, 235599, 456778, 456779, 333899, 366667, 444488, 366666, 444489, 456777, 157778, 366677, 157779, 247889, 366679, 456788, 157777, 247888, 366678, 444499, 247899, 456799, 157788, 157789, 223335, 366689, 157799, 223334, 366688, 223333, 223339, 223338, 223337, 223336, 366699, 223347, 223346, 223345, 378999, 223344, 223349, 223348, 223355, 223359, 288888, 223358, 288889, 223357, 223356, 223367, 223366, 288899, 444558, 444559, 223369, 444556, 223368, 444557, 444555, 223379, 235667, 444566, 145555, 223378, 235666, 444567, 223377, 145558, 145559, 145556, 235669, 145557, 235668, 145566, 145567, 223389, 235677, 444568, 223388, 444569, 145568, 145569, 223399, 444578, 444579, 444577, 145578, 145579, 333999, 444588, 145577, 235688, 444589, 235699, 444599, 145588, 145589, 247999, 366777, 145599, 366779, 456888, 366778, 456889, 366789, 366788, 157888, 157889, 456899, 157899, 366799, 223447, 223446, 223445, 223444, 223449, 223448, 223455, 223459, 223458, 223457, 223456, 288999, 223467, 223466, 223469, 223468, 223479, 223478, 223477, 444668, 444669, 444666, 444667, 145666, 235779, 444678, 145667, 235778, 444679, 223489, 235777, 223488, 444677, 145668, 145669, 223499, 145677, 235788, 235799, 444688, 444689, 145688, 444699, 145699, 456999, 366889, 157999, 366888, 366899, 223555, 223559, 223558, 223557, 223556, 223567, 223566, 223569, 223568, 223579, 223578, 223577, 223589, 223588, 223599, 444778, 444779, 444777, 145778, 145779, 235889, 444788, 145777, 235888, 444789, 235899, 444799, 239999, 145788, 448888, 448889, 145799, 448899, 366999, 579999, 223667, 223666, 223669, 223668, 223679, 223678, 223677, 227779, 227778, 227777, 223689, 223688, 227789, 227788, 223699, 227799, 235999, 444888, 444889, 448999, 145888, 145889, 567788, 444899, 567789, 145899, 567777, 567778, 567779, 358889, 149999, 358888, 358899, 567799, 489999, 223779, 223778, 223777, 555566, 555567, 346669, 346668, 555555, 555556, 555557, 223789, 346667, 555558, 223788, 346666, 555559, 137778, 346677, 137779, 555577, 227889, 346679, 555578, 137777, 227888, 346678, 555579, 223799, 227899, 555568, 555569, 137788, 137789, 444999, 346689, 137799, 346688, 555599, 555588, 145999, 555589, 346699, 358999, 567899, 477779, 477778, 477777, 567888, 567889, 477789, 477788, 268888, 268889, 477799, 268899, 334445, 334444, 334447, 334446, 334455, 334449, 334448, 399999, 334457, 334456, 334459, 334458, 334469, 334468, 334467, 334466, 334477, 334479, 334478, 223889, 223888, 555677, 555678, 555679, 223899, 256667, 256666, 555666, 555667, 227999, 334489, 346777, 555668, 334488, 555669, 256669, 346779, 256668, 346778, 555688, 346788, 555689, 137888, 137889, 256679, 256678, 256677, 334499, 137899, 346799, 256689, 256688, 567999, 256699, 555699, 268999, 477889, 477888, 178888, 178889, 477899, 178899, 334557, 334556, 334559, 334558, 244447, 244446, 244445, 334555, 244444, 244449, 334567, 244448, 334566, 244455, 244459, 244458, 244457, 244456, 334569, 334568, 244467, 244466, 334577, 244469, 334579, 244468, 334578, 334589, 334588, 223999, 244479, 244478, 244477, 334599, 555788, 555789, 166666, 256779, 166667, 256778, 555777, 244489, 256777, 555778, 244488, 555779, 346889, 137999, 346888, 166668, 166669, 244499, 166678, 166679, 346899, 166677, 256788, 256799, 555799, 166688, 166689, 477999, 166699, 178999, 244555, 334669, 334668, 244559, 244558, 244557, 334667, 244556, 334666, 334677, 334679, 334678, 244567, 244566, 244569, 244568, 244579, 244578, 244577, 334689, 334688, 244589, 334699, 244588, 346999, 555899, 244599, 559999, 166778, 555888, 166779, 555889, 256889, 166777, 256888, 256899, 166788, 166789, 166799, 244667, 244666, 334777, 244669, 334779, 244668, 334778, 334789, 334788, 244679, 244678, 244677, 334799, 338889, 338888, 244689, 244688, 338899, 555999, 244699, 256999, 469999, 166888, 166889, 166899, 244779, 244778, 244777, 334889, 334888, 338999, 457778, 457779, 244789, 334899, 244788, 457777, 248889, 457788, 248888, 457789, 244799, 248899, 457799, 166999, 379999, 445558, 445559, 445556, 445557, 445555, 236667, 445566, 236666, 445567, 236669, 236668, 236679, 236678, 236677, 445568, 445569, 445578, 445579, 445577, 236689, 334999, 445588, 236688, 445589, 236699, 445599, 244889, 244888, 244899, 248999, 367777, 367779, 457888, 367778, 457889, 367789, 367788, 158888, 158889, 457899, 158899, 367799, 224447, 224446, 224445, 224444, 224449, 224448, 224455, 224459, 224458, 224457, 224456, 289999, 224467, 224466, 224469, 224468, 224479, 224478, 224477, 355557, 355556, 355559, 445668, 355558, 445669, 445666, 445667, 355555, 146666, 236779, 445678, 146667, 236778, 445679, 224489, 236777, 355567, 224488, 355566, 445677, 146668, 146669, 224499, 146678, 355569, 146679, 355568, 146677, 236788, 236799, 355577, 355579, 445688, 355578, 445689, 355589, 355588, 146688, 146689, 244999, 445699, 146699, 457999, 355599, 367889, 158999, 277777, 367888, 277778, 277779, 277788, 277789, 367899, 277799, 224555, 224559, 224558, 224557, 224556, 224567, 224566, 224569, 224568, 199999, 224579, 224578, 224577, 224589, 224588, 355669, 355668, 224599, 445778, 445779, 355667, 355666, 445777, 146778, 355677, 146779, 236889, 355679, 445788, 146777, 236888, 355678, 445789, 236899, 445799, 146788, 355689, 146799, 355688, 355699, 367999, 277888, 277889, 277899, 224667, 224666, 224669, 224668, 134566, 224679, 224678, 224677, 224689, 134577, 224688, 224699, 134588, 236999, 355777, 134599, 355779, 445888, 355778, 445889, 355789, 355788, 449999, 146888, 146889, 445899, 146899, 355799, 277999, 134666, 224779, 134667, 224778, 224777, 134668, 134669, 224789, 134677, 224788, 228889, 228888, 224799, 228899, 134688, 134699, 445999, 568888, 568889, 355889, 146999, 355888, 359999, 355899, 568899, 556666, 556667, 556668, 556669, 134778, 134779, 224889, 134777, 224888, 224899, 228999, 347777, 134788, 347779, 347778, 347789, 347788, 138888, 138889, 134799, 556677, 556678, 556679, 138899, 347799, 556699, 556688, 556689, 355999, 269999, 478889, 478888, 568999, 478899, 335557, 335556, 335559, 335558, 335555, 335567, 335566, 335569, 335568, 335577, 335579, 335578, 335589, 335588, 556777, 556778, 556779, 224999, 134888, 335599, 466669, 134889, 466668, 466667, 466666, 257779, 466679, 134899, 257778, 466678, 257777, 466677, 347889, 138999, 347888, 556799, 556788, 556789, 257789, 347899, 257788, 257799, 466689, 466688, 466699, 478999, 388889, 179999, 388888, 388899, 245555, 335669, 335668, 245559, 245558, 245557, 335667, 245556, 335666, 335677, 335679, 335678, 245567, 245566, 245569, 245568, 245579, 245578, 245577, 335689, 335688, 556888, 556889, 134999, 245589, 335699, 245588, 347999, 245599, 466779, 466778, 466777, 167778, 167779, 257889, 466789, 167777, 257888, 466788, 257899, 466799, 556899, 167788, 167789, 233335, 167799, 233334, 233333, 233339, 233338, 233337, 233336, 233347, 233346, 233345, 388999, 233344, 233349, 233348, 233355, 233359, 233358, 233357, 233356, 233367, 233366, 233369, 233368, 233379, 245667, 155555, 233378, 245666, 233377, 155558, 335777, 155559, 155556, 245669, 335779, 155557, 245668, 335778, 335789, 335788, 155566, 155567, 233389, 245677, 233388, 155568, 335799, 155569, 233399, 155578, 155579, 155577, 245688, 245699, 155588, 155589, 257999, 155599, 466889, 466888, 556999, 167888, 167889, 466899, 167899, 233447, 233446, 233445, 233444, 233449, 233448, 233455, 233459, 233458, 233457, 233456, 233467, 233466, 233469, 233468)

    val evenSmallerListOfPasswords = passwordOptions.filter { isPossiblePasswordv2(it) }

    println("possible passwords/total combinations: ${evenSmallerListOfPasswords.size}/${passwordOptions.size}")
}

fun isPossiblePasswordv2(num: Int): Boolean {
    var numberCount = HashMap<Int, Int>()
    for (i in 5 downTo 0) {
        val divisor = (Math.pow(10.toDouble(), i.toDouble())).toInt()
        val digit = ((num / divisor) % 10).toInt()
        numberCount.put(digit, numberCount.getOrDefault(digit, 0) + 1)
    }

    return numberCount.any { (_, v) ->
        v == 2
    }
}

fun isPossiblePassword(num: Int): Boolean {
    // must be a 6 digit number
    println("validating the number has 6 digits")
    if ((99_999 > num) or (num > 1_000_000)) {
        println("the number is not 6 digits")
        return false
    }

    // validate that there are two adjacent same digits
    println("validating for two adjacent digits")
    // 122345 / 1 * 100000
    var previous = 0
    var adjacent = false
    for (i in 5 downTo 0) {
        val divisor = (Math.pow(10.toDouble(), i.toDouble())).toInt()
        val digit = ((num / divisor) % 10).toInt()
        // adjacent numbers!
        if (previous == digit) {
            println("two in a row! $previous -> $digit")
            adjacent = true
            break
        }
        previous = digit
    }

    if (!adjacent) {
       return false
    }

    // validate the digits do not decrease
    println("validating for no decreases")
    previous = 0
    for (i in 5 downTo 0) {
        val divisor = (Math.pow(10.toDouble(), i.toDouble())).toInt()
        val digit = ((num / divisor) % 10).toInt()
        if (previous > digit) {
            println("the digit decreases")
            return false
        }
        previous = digit
    }

    return true
}