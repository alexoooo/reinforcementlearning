package ao.ai.evo.chromosome;

import ao.ai.evo.chromosome.recombine.Recombiner;
import ao.ai.evo.gene.Gene;
import ao.ai.evo.gene.synthesis.RandomGeneSynthesizer;
import ao.ai.evo.heredity.Heritable;
import ao.ai.evo.primordial_soup.PrimordialSoup;
import ao.ai.rl.gp.op.TerminalReached;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;


/**
 * 
 */
public class Chromosome implements Heritable<Chromosome>
{
    //--------------------------------------------------------------------
    private Gene root;

    private Factory      factory;
    private Recombiner   recombiner;
    private MicroMutator microMutator;
    private MacroMutator macroMutator;


    //--------------------------------------------------------------------
    public Chromosome() {}

    @Singleton
    public static class Factory
    {
        private RandomGeneSynthesizer thoughtTreeFactory;
        private Provider<Chromosome> branchProvider;

        public Chromosome randomInstance(PrimordialSoup thoughts)
        {
            Chromosome branch = branchProvider.get();
            branch.root = thoughtTreeFactory.randomInstance(thoughts);
            return branch;
        }

        public Chromosome copy(Chromosome branch)
        {
            Chromosome copyBranch = branchProvider.get();
            copyBranch.root = branch.root.replicate();
            return copyBranch;
        }

        private Chromosome blankCopy()
        {
            return branchProvider.get();
        }

        @Inject
        public void injectThoughtTreeFactory(
                RandomGeneSynthesizer injectedThoughtTreeFactory)
        {
            thoughtTreeFactory = injectedThoughtTreeFactory;
        }

        @Inject
        public void injectBranchProvider(
                Provider<Chromosome> injectedBranchProvider)
        {
            branchProvider = injectedBranchProvider;
        }
    }

    
    //--------------------------------------------------------------------
    @Inject
    public void injectBranchFactory(Factory injectedFactory)
    {
        factory = injectedFactory;
    }

    @Inject
    public void injectRecombiner(Recombiner injectedRecombiner)
    {
        recombiner = injectedRecombiner;
    }

    @Inject
    public void injectMicroMutator(MicroMutator injectedMicroMutator)
    {
        microMutator = injectedMicroMutator;
    }

    @Inject
    public void injectMacroMutator(MacroMutator injectedMacroMutator)
    {
        macroMutator = injectedMacroMutator;
    }


    //--------------------------------------------------------------------
    public int size()
    {
        return root.size();
    }


    //--------------------------------------------------------------------
    public Chromosome replicate()
    {
        return factory.copy(this);
    }


    //--------------------------------------------------------------------
    public Chromosome microMutate(PrimordialSoup thoughts)
    {
        Chromosome copy = factory.blankCopy();
        copy.root = microMutator.microMutate(root, thoughts);
        return copy;
    }


    //--------------------------------------------------------------------
    public Chromosome macroMutate(PrimordialSoup thoughts)
    {
        Chromosome copy = factory.blankCopy();
        copy.root = macroMutator.macroMutate(root, thoughts);
//        if (copy.size() != size())
//        {
//            System.out.println("macro delta: " + (copy.size() - size()) +
//                               " to " + copy.size());
//        }

        return copy;
    }


    //--------------------------------------------------------------------
    public Chromosome recombine(Chromosome partner)
    {
        Chromosome copy = factory.blankCopy();
        copy.root = recombiner.cross(root, partner.root);
//        if (copy.size() != size())
//        {
//            System.out.println("cross delta: " + (copy.size() - size()) +
//                               " to " + copy.size());
//        }
        return copy;
    }


    //--------------------------------------------------------------------
    public void execute()
    {
        try
        {
            root.express().build();
        }
        catch (Throwable error)
        {
            Throwable root = error;
            while (root.getCause() != null)
            {
                root = root.getCause();
            }

            if (root instanceof TerminalReached)
            {
                // program returned normally
            }
            else
            {
                error.printStackTrace();
            }
        }
    }


    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
//        return String.valueOf( root.size() );
        return root.toTreeString();
    }
}
