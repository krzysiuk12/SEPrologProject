package pl.edu.agh.prolog.db;

import pl.edu.agh.prolog.service.PrologExpertConfiguration;

/**
 *
 * @author ps_krzysztof
 */
public class Questions {
    
    private static final String FEATURES_TYPE = "Typy osobowości";
    private static final String FEALINGS_TYPE = "Usposobienie";
    
    public static enum Features implements IQuestionable<PrologExpertConfiguration.Features> {
        
        DIRECT("Czy jesteś bezpośredni?", PrologExpertConfiguration.Features.DIRECT),
        BRILLIANT("Czy jesteś błyskotliwy?", PrologExpertConfiguration.Features.BRILLIANT),
        PATIENT("Czy jesteś cierpliwy?", PrologExpertConfiguration.Features.PATIENT),
        EMPATHIC("Czy jesteś osobą empatyczną?", PrologExpertConfiguration.Features.EMPATHIC),
        ENERGETIC("Czy jesteś osobą energiczną?", PrologExpertConfiguration.Features.ENERGETIC),
        ENIGMATIC("Czy jesteś osobą enigmatyczną?", PrologExpertConfiguration.Features.ENIGMATIC),
        ENTHUSIASTIC("Czy jesteś entuzjasttyczny?", PrologExpertConfiguration.Features.ENTHUSIASTIC),
        INDIVIDUALIST("Czy jesteś indywidualistą?", PrologExpertConfiguration.Features.INDIVIDUALIST),
        INSPIRING("Czy jesteś osobą inspirującą?", PrologExpertConfiguration.Features.INSPIRING),
        COMPETENT("Czy jesteś kompetentny?", PrologExpertConfiguration.Features.COMPETENT),
        LOGICAL("Czy jesteś osobą logiczną?", PrologExpertConfiguration.Features.LOGICAL),
        LOYAL("Czy jesteś lojalny?", PrologExpertConfiguration.Features.LOYAL),
        INDEPENDENT("Czy jesteś osobą niezależną?", PrologExpertConfiguration.Features.INDEPENDENT),
        STRESS_RESISTANT("Czy jesteś odporny na stres?", PrologExpertConfiguration.Features.STRESS_RESISTANT),
        RESPONSIBLE("Czy jesteś odpowiedzialny?", PrologExpertConfiguration.Features.RESPONSIBLE),
        OPTIMISTIC("Czy jesteś osobą optymistyczną?", PrologExpertConfiguration.Features.OPTIMISTIC),
        CONFIDENT("Czy jesteś pewny siebie?", PrologExpertConfiguration.Features.CONFIDENT),
        HARDWORKING("Czy jesteś pracowity?", PrologExpertConfiguration.Features.HARDWORKING),
        PRACTICAL("Czy jesteś osobą praktyczną?", PrologExpertConfiguration.Features.PRACTICAL),
        ENTERPRISING("Czy jesteś przedsiębiorczy?", PrologExpertConfiguration.Features.ENTERPRISING),
        RATIONAL("Czy jesteś osobą racjonalną?", PrologExpertConfiguration.Features.RATIONAL),
        MATTER_OF_FACT("Czy jesteś rzeczowy?", PrologExpertConfiguration.Features.MATTER_OF_FACT),
        CORDIAL("Czy jesteś serdeczny?", PrologExpertConfiguration.Features.CORDIAL),
        SPONTANEOUS("Czy jesteś spontaniczny?", PrologExpertConfiguration.Features.SPONTANEOUS),
        CONSCIENTIOUS("Czy jesteś sumienny?", PrologExpertConfiguration.Features.CONSCIENTIOUS),
        SOCIAL("Czy jesteś towarzyski?", PrologExpertConfiguration.Features.SOCIAL),
        CREATIVE("Czy jesteś osobą twórczą?", PrologExpertConfiguration.Features.CREATIVE),
        TRUSTING("Czy jesteś osobą ufną?", PrologExpertConfiguration.Features.TRUSTING),
        SENSITIVE("Czy jesteś wrażliwy?", PrologExpertConfiguration.Features.SENSITIVE),
        PERSISTENT("Czy jesteś osobą wytrwałą?", PrologExpertConfiguration.Features.PERSISTENT),
        DETACHED("Czy jesteś osobą zdystansowaną?", PrologExpertConfiguration.Features.DETACHED),
        ORGANIZED("Czy jesteś osobą zorganizowaną?", PrologExpertConfiguration.Features.ORGANIZED);

        private final String question;
        private final PrologExpertConfiguration.Features expertFeature;

        private Features(String question, PrologExpertConfiguration.Features expertFeature) {
            this.question = question;
            this.expertFeature = expertFeature;
        }

        @Override
        public String getQuestion() {
            return question;
        }

        @Override
        public PrologExpertConfiguration.Features getExpertVariable() {
            return expertFeature;
        }

        @Override
        public String getType() {
            return FEATURES_TYPE;
        }
        
    }
    
    public static enum Fealings implements IQuestionable<PrologExpertConfiguration.Fealings> {
        
        SADNESS("Czy odczuwasz smutek lub przygnębienie?", PrologExpertConfiguration.Fealings.SADNESS),
        BAD_MOOD("Czy masz groszy nastrój?", PrologExpertConfiguration.Fealings.BAD_MOOD),
        DISCOURAGEMENT("Czy czujesz się zniechęcony?", PrologExpertConfiguration.Fealings.DISCOURAGEMENT),
        LONELINESS("Czy czujesz się samotny?", PrologExpertConfiguration.Fealings.LONELINESS),
        TIREDNESS("Czy odczuwasz zmęczenie?", PrologExpertConfiguration.Fealings.TIREDNESS),
        GOOD_DAY("Czy miałeś dziś dobry dzień?", PrologExpertConfiguration.Fealings.GOOD_DAY),
        CONTENTMENT("Czy jesteś zadowolony z siebie?", PrologExpertConfiguration.Fealings.CONTENTMENT),
        MOTIVATION("Czy czujesz się zmotywowany?", PrologExpertConfiguration.Fealings.MOTIVATION),
        JOY("Czy odczuwasz radość?", PrologExpertConfiguration.Fealings.JOY);
            
        private final String question;
        private final PrologExpertConfiguration.Fealings expertFealing;

        private Fealings(String question, PrologExpertConfiguration.Fealings expertFealing) {
            this.question = question;
            this.expertFealing = expertFealing;
        }

        @Override
        public String getQuestion() {
            return question;
        }

        @Override
        public PrologExpertConfiguration.Fealings getExpertVariable() {
            return expertFealing;
        }

        @Override
        public String getType() {
            return FEALINGS_TYPE;
        }
        
    }
    
}
