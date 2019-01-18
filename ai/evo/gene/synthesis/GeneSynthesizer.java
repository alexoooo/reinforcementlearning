package ao.ai.evo.gene.synthesis;

import ao.ai.evo.gene.Gene;
import ao.ai.evo.primordial_soup.PrimordialSoup;
import ao.ai.evo.promoter.affinity.Affinity;
import ao.ai.evo.chromosome.config.TreeGenParams;
import com.google.inject.ImplementedBy;

/**
 * 
 */
@ImplementedBy(GeneSynthesizerImpl.class)
public interface GeneSynthesizer
{
    //--------------------------------------------------------------------
    // Generates a full gene, ie. a gene with and all of its
    //  dependencies, and all of their dependencies recursivel.
    public Gene synthesize(
            TreeGenParams  params,
            Affinity       returning,
            PrimordialSoup ops);
}